package com.omarelassal.minu.controller;

import com.omarelassal.minu.dto.UrlMapDto;
import com.omarelassal.minu.service.UrlShortenService;
import com.omarelassal.minu.utils.URLValidator;
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

        // Check if the scheme and subdomain are valid, and add them if missing
        if (!URLValidator.isSchemeSubdomain(originalURL)) {
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
            return new RedirectView(updatedURL);
        }

        return new RedirectView(originalURL);
    }


}
