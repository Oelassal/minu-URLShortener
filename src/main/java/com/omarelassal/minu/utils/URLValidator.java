package com.omarelassal.minu.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
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

//    Check for Scheme and subdomain in the original url
    public static boolean isSchemeSubdomain(String originalUrl) {
    if (originalUrl.startsWith("http://") || originalUrl.startsWith("https://")) {
        int wwwIndex = originalUrl.indexOf("www.");
        return wwwIndex > 0;
    }
    return false;
    }
}
