package com.omarelassal.minu.utils;

import java.util.regex.Pattern;

public class URLValidator {
//    Regex to Confirm URL is real not a normal String
    private static final String URL_Regex = "^(https?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(/.*)?$";

// serialize the regex into pattern (byte)
    private static final Pattern URL_PATTERN = Pattern.compile(URL_Regex,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    public static boolean isValid(String url) {
//        remove tabs,spaces,newLines,etc..
        String strippedUrl = url.replaceAll("\\s", "").replaceAll("\\n", "").replaceAll("\\r", "").replaceAll("\\t", "").replaceAll("\\\\", "");
        return URL_PATTERN.matcher(strippedUrl).matches();
    }
}
