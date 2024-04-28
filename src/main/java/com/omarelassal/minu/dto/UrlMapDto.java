package com.omarelassal.minu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlMapDto {
    private String originalUrl;
    private String shortUrl;
}
