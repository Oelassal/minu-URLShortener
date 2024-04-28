package com.omarelassal.minu.service.impl;

import com.omarelassal.minu.dto.UrlMapDto;
import com.omarelassal.minu.mapper.UrlMapper;
import com.omarelassal.minu.model.Url;
import com.omarelassal.minu.repo.UrlRepository;
import com.omarelassal.minu.service.UrlShortenService;
import com.omarelassal.minu.utils.SHA256HashGenerator;
import com.omarelassal.minu.utils.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenServiceImpl implements UrlShortenService {

    @Autowired
    private UrlRepository urlRepository;

    /* Url Shortener*/
    @Override
    public UrlMapDto shortenUrl(String originalURL) {
        if (!URLValidator.isValid(originalURL)) {
            throw new IllegalArgumentException("Invalid URL provided");
        }
        String hash = SHA256HashGenerator.generateSHA256Hash(originalURL);
        String shortUrl = hash.substring(0,6);
        Url url = new Url();
        url.setOriginalUrl(originalURL);
        url.setShortUrl(shortUrl);
        Url savedUrl = urlRepository.save(url);
        return UrlMapper.toDto(savedUrl);
    }

    /*revert back shortURL to originalURL*/
    @Override
    public String getOriginalUrl(String shortUrl) {
        Url urlMap = urlRepository.findByshortUrl(shortUrl);
        return urlMap != null ? urlMap.getOriginalUrl() : "Original Url Doesn't Exist";
    }


}
