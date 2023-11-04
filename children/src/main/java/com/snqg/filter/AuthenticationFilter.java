package com.snqg.filter;

import com.snqg.children.constant.RedisPrefix;
import com.snqg.common.exception.BusinessException;
import com.snqg.common.exception.ThrowUtil;
import com.snqg.common.util.*;
import com.snqg.context.UserHolder;
import com.snqg.domain.enums.ErrorCode;
import io.jsonwebtoken.Claims;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(-1)
public class AuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private RedisCache redisCache;

    public static final PrefixMatcher matcher = new PrefixMatcher("/children/login",
            "/doc.html", "/img/*", "/favicon.ico", "/swagger-resources", "/v2*", "/webjars*", "/swagger-ui*");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("token");
        String uri = request.getRequestURI();
        System.out.println(uri);

        //如果uri与白名单匹配，则直接放行
        if(matcher.match(uri)) {
            filterChain.doFilter(request, response);
            return;
        }

        ThrowUtil.throwIf(StrUtil.isBlank(token),
            "认证失败：token为空");

        String userId;

        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            //token 不合法
            throw new BusinessException(ErrorCode.ILLEGAL_PARAM_ERROR, "认证失败：非法token");
        }

        String encodedToken = redisCache.getCacheObject(RedisPrefix.USER_SESSION_TOKEN + userId);

        //jwt已失效
        ThrowUtil.throwIf(!StrEncoder.check(token, encodedToken),
                "认证失败：token已失效，请重新登录");

        UserHolder.setUserId(userId);

        filterChain.doFilter(request,response);
    }

}
