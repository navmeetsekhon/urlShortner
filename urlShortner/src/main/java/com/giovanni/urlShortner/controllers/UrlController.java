package com.giovanni.urlShortner.controllers;

import com.giovanni.urlShortner.services.QrService;
import com.giovanni.urlShortner.services.UrlService;
import com.giovanni.urlShortner.dto.QrRequest;
import com.giovanni.urlShortner.dto.QrResponse;
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

    @Autowired
    private QrService qrService;

    @PostMapping("/createUrl")
    public ShortUrlResponse shortenUrl(@RequestBody ShortUrlRequest request){
        return urlService.shortenUrl(request);
    }
    @GetMapping("{shortUrl}")
    public RedirectView getOriginalUrl(@PathVariable String shortUrl){
        return urlService.getFullUrl(shortUrl);
    }

    @PostMapping("/QrGen")
    public QrResponse generateQr(@RequestBody QrRequest Url){
        return qrService.generateQr(Url);
    }
}
