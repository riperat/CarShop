package com.example.carshop.util;

public class TextUtil {

    public static boolean isNullorEmpty(String value) {
        return value.length() == 0 || value.isBlank() || value.equals(null);
    }

}
