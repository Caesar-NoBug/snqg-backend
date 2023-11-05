package com.snqg.domain.constant;

import java.nio.charset.Charset;

public class StrConstant {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String ERROR_CONTROLLER_PATH = "/filter/error";
    public static final String ERROR_ATTRIBUTE = "filterError";

}