package com.snqg.common.exception;

import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;
import com.snqg.domain.constant.StrConstant;
import com.snqg.domain.enums.ErrorCode;
import com.snqg.domain.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Order(Integer.MIN_VALUE)
@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(request, response);
        } catch (BusinessException e) {

            //将异常封装成Response
            Response<Void> errorResponse = Response.error(e.getCode(), e.getMessage());

            //将Response输出到响应体中
            response.setContentType(ContentType.JSON.getValue());
            response.setCharacterEncoding(StrConstant.DEFAULT_CHARSET_NAME);
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(errorResponse));
            writer.close();

        }
    }
}
