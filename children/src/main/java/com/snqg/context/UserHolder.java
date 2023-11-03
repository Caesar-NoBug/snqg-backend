package com.snqg.context;


public class UserHolder {

    private static final ThreadLocal<String> userInfo = new ThreadLocal<>();

    public static void setUserId(String userId) {
        userInfo.set(userId);
    }

    public static String getUserId() {
        return userInfo.get();
    }

}
