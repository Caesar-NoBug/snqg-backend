package com.snqg.common.util;

import cn.hutool.crypto.digest.DigestUtil;

//加密原始密码
public class PasswordEncoder {

    /**
     * @param rawString 原始字符串
     * @return 加密后字符串
     */
    public static String encode(String rawString) {
        return DigestUtil.bcrypt(rawString);
    }

    /**
     * @param rawString 待判断字符串
     * @param encodedString 加密后字符串
     * @return 是否匹配
     */
    public static boolean check(String rawString, String encodedString) {
        return DigestUtil.bcryptCheck(rawString, encodedString);
    }

}
