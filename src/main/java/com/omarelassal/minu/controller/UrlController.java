package com.omarelassal.minu.controller;

import com.omarelassal.minu.dto.UrlMapDto;
import com.omarelassal.minu.service.UrlShortenService;
import com.omarelassal.minu.service.UrlValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/minu")
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {

    @Autowired
    private UrlShortenService urlShortenService;

    @Autowired
    private UrlValidationService urlValidationService;




    @PostMapping("/shorten")
    ResponseEntity<String> generateShortUrl(@RequestBody String url) {
        UrlMapDto shortURL = urlShortenService.shortenUrl(url);

        // Get the base URL dynamically using ServletUriComponentsBuilder
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
        String baseUrl = builder.build().toUriString();

        // Append the short URL to the base URL
        String fullShortURL = baseUrl + "/minu/" + shortURL.getShortUrl();

        return ResponseEntity.created(URI.create(fullShortURL)).body(fullShortURL);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable("shortUrl") String shortUrl) {
        String originalURL = urlShortenService.getOriginalUrl(shortUrl);
        if (originalURL.equals("Original Url Doesn't Exist")) {
            return new RedirectView("/errorPage"); // Redirect to a custom error page
        }

        String validatedURL = urlValidationService.validateAndModifyURL(originalURL);

        return new RedirectView(validatedURL);
    }


}
