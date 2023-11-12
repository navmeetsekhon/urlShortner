package repository;

import models.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlEntity,Long> {
    UrlEntity findByKey(String shortUrl);
    UrlEntity findByOriginalUrl(String orginalUrl);
}
