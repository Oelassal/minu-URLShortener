package com.omarelassal.minu.mapper;

import com.omarelassal.minu.dto.UrlMapDto;
import com.omarelassal.minu.model.Url;

public class UrlMapper {

    public static UrlMapDto toDto(Url url) {
        UrlMapDto urlMapDto = new UrlMapDto();
        urlMapDto.setOriginalUrl(url.getOriginalUrl());
        urlMapDto.setShortUrl(url.getShortUrl());
        return urlMapDto;
    }


}
