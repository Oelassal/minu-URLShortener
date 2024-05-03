package com.omarelassal.minu.service;

public interface UrlValidationService {

    String validateAndModifyURL(String originalURL);

    String addSchemeAndSubdomain(String originalURL);

}
