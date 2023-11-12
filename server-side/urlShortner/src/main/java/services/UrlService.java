package services;

import dto.ShortUrlRequest;
import dto.ShortUrlResponse;
import models.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import repository.UrlRepository;
import util.ShortUrlUtil;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private ShortUrlUtil shortUrlUtil;

    public ShortUrlResponse shortenUrl(ShortUrlRequest shortUrlRequest){
        String fullUrl=shortUrlRequest.getUrl();

        UrlEntity existingShortUrl=urlRepository.findByOriginalUrl(fullUrl);

        if(existingShortUrl!=null){
            return ShortUrlResponse.builder().key(existingShortUrl.getUrlKey()).build();
        }
        else {
            String newKey=shortUrlUtil.generateUniqueKey();
            UrlEntity newEntity=UrlEntity.builder().urlKey(newKey).originalUrl(fullUrl).clickCount(0L).build();
            urlRepository.save(newEntity);
            return ShortUrlResponse.builder().key(newKey).build();
        }
    }
    public RedirectView getFullUrl(String key){
        if(key!=null){
            UrlEntity entity=urlRepository.findByKey(key);
            entity.setClickCount(entity.getClickCount()+1);
            urlRepository.save(entity);
            return new RedirectView(entity.getOriginalUrl());
        }
        else {
            return new RedirectView("/not-found");
        }


    }

}
