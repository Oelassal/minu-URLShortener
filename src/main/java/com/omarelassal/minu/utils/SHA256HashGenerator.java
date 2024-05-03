package com.omarelassal.minu.utils;

import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.time.Instant;

public class SHA256HashGenerator {

    public static String generateSHA256Hash(String input) {
        try{
            String uniqueIdentifier = input + Instant.now().toEpochMilli();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(uniqueIdentifier.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }catch(Exception e){
            e.getMessage();
            e.printStackTrace();
            return "No such hash, please try again.";
        }
    }
}
