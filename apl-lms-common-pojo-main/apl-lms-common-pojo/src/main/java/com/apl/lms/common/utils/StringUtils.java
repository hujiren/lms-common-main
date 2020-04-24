package com.apl.lms.common.utils;

/**
 * @author hjr start
 * @date 2020/4/20 - 15:35
 */
public class StringUtils {
    public static String removeEmpty(String str) {
        if (str == null || str.trim().length()==0){
            return  null;
        }

        return str;
    }
}

