package com.giovanni.urlShortner.util;

import com.giovanni.urlShortner.config.ShortUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
//util class handles generic functions such as generating key.
@Component
public class ShortUrlUtil {
    @Autowired
    private ShortUrlConfig shortUrlConfig;

    public String generateUniqueKey(){
        int keyLength=shortUrlConfig.getKeyLength();
        String allowedCharacters=shortUrlConfig.getAllowedCharacters();

        StringBuilder keyBuilder=new StringBuilder();
        Random random=new Random();

        for (int i=0;i<keyLength;i++){
            int randomIndex= random.nextInt(allowedCharacters.length());
            keyBuilder.append(allowedCharacters.charAt(randomIndex));
        }
        return keyBuilder.toString();
    }
}
