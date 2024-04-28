package com.omarelassal.minu.controller;

import com.omarelassal.minu.dto.UrlMapDto;
import com.omarelassal.minu.service.UrlShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/minu")
public class UrlController {

    @Autowired
    private UrlShortenService urlShortenService;


    @PostMapping("/shorten")
    ResponseEntity<String> generateShortUrl(@RequestBody String url) {
        UrlMapDto shortURL = urlShortenService.shortenUrl(url);

        // Get the base URL dynamically using ServletUriComponentsBuilder
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
        String baseUrl = builder.build().toUriString();

        // Append the short URL to the base URL
        String fullShortURL = baseUrl + "/redirect/" + shortURL.getShortUrl();

        return ResponseEntity.created(URI.create(fullShortURL)).body(fullShortURL);
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable("shortUrl") String shortUrl) {
        String originalURL = urlShortenService.getOriginalUrl(shortUrl);

        // Get the base URL dynamically using ServletUriComponentsBuilder
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
        String baseUrl = builder.build().toUriString();

        // Construct the full original URL dynamically
        String fullOriginalURL = baseUrl + "/redirect/" + shortUrl;

        return urlShortenService.getOriginalUrl(shortUrl);

    }


}
