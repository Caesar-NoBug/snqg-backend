package com.snqg.common.util;

import com.alibaba.fastjson.JSONObject;
import com.snqg.common.exception.ThrowUtil;
import com.snqg.domain.enums.ErrorCode;
import com.snqg.domain.response.wx.WxLoginResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.Objects;

@Component
public class WechatUtil {
    public static final String APP_ID = "wx227fbffcc53150e5";
    public static final String APP_SECRET = "369e483e244f752ed34e19d584453ced";
    public static final String WECHAT_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Resource
    private RestTemplate restTemplate;

    //通过前端的code获取用户微信账号相关信息
    public WxLoginResponse wechatLogin(String code) {

        String url = String.format(WECHAT_LOGIN_URL, APP_ID, APP_SECRET, code);
        JSONObject jsonObject = JSONObject.parseObject(restTemplate.getForObject(url, String.class));

        WxLoginResponse response = new WxLoginResponse();

        ThrowUtil.throwIf(!Objects.isNull(jsonObject.getString("errorcode")),
                ErrorCode.ILLEGAL_PARAM_ERROR, jsonObject.getString("errmsg"));

        response.setOpenid(jsonObject.getString("openid"));
        response.setSessionKey(jsonObject.getString("session_key"));
        response.setUnionId(jsonObject.getString("unionid"));

        return response;
    }

}
