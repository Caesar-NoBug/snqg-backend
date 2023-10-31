package com.snqg.domain.response.wx;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WxLoginResponse {
    //用户唯一标识
    private String openid;
    //会话密钥
    private String sessionKey;
    //用户在开放平台的唯一标识符, 小程序已绑定到微信开放平台账号下才会返回
    private String unionId;
}
