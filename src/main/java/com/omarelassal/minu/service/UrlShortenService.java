package com.omarelassal.minu.service;

import com.omarelassal.minu.dto.UrlMapDto;

public interface UrlShortenService {
    UrlMapDto shortenUrl(String origianlURL);
    String getOriginalUrl(String shortUrl);
}
