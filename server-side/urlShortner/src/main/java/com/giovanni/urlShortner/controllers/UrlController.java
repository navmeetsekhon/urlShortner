package com.giovanni.urlShortner.controllers;

import com.giovanni.urlShortner.services.UrlService;
import com.giovanni.urlShortner.dto.ShortUrlRequest;
import com.giovanni.urlShortner.dto.ShortUrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path="/v1")
public class UrlController {
    @Autowired
    private UrlService urlService;
    @PostMapping("/createUrl")
    public ShortUrlResponse shortenUrl(@RequestBody ShortUrlRequest request){
        return urlService.shortenUrl(request);
    }
    @GetMapping("{shortUrl}")
    public RedirectView getOriginalUrl(@PathVariable String shortUrl){
        return urlService.getFullUrl(shortUrl);
    }

    @GetMapping("/test")
    public String testApi(){
        return "Server is up";
    }
}
