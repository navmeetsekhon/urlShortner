package com.giovanni.urlShortner.repository;

import com.giovanni.urlShortner.models.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlEntity,Long> {
    UrlEntity findByUrlKey(String shortUrl);
    UrlEntity findByOriginalUrl(String orginalUrl);
}
