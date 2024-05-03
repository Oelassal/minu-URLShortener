package com.omarelassal.minu.service.impl;

import com.omarelassal.minu.service.UrlValidationService;
import com.omarelassal.minu.utils.URLValidator;
import org.springframework.stereotype.Service;

@Service
public class URLValidationServiceImpl implements UrlValidationService {
    
    public String validateAndModifyURL(String originalURL) {
        if (!URLValidator.isSchemeSubdomain(originalURL)) {
            return addSchemeAndSubdomain(originalURL);
        }
        return originalURL;
    }

    public String addSchemeAndSubdomain(String originalURL) {
        String updatedURL = originalURL;
        if (!originalURL.startsWith("http://") && !originalURL.startsWith("https://")) {
            // Add the http scheme if missing
            updatedURL = "http://" + originalURL;
        }
        if (!originalURL.contains("www.")) {
            // Add the www subdomain if missing
            updatedURL = updatedURL.replaceFirst("http://", "http://www.");
            updatedURL = updatedURL.replaceFirst("https://", "https://www.");
        }
        return updatedURL;
    }
}