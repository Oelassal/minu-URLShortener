package com.omarelassal.minu.repo;

import com.omarelassal.minu.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

    Url findByshortUrl(String id);
}
