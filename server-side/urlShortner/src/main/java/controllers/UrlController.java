package controllers;

import dto.ShortUrlRequest;
import dto.ShortUrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import services.UrlService;

@RestController
@RequestMapping(path="/v1")
public class UrlController {
    @Autowired
    private UrlService urlService;
    @PostMapping("/createUrl")
    public ShortUrlResponse shortenUrl(@RequestBody String shortUrl){
        ShortUrlRequest request=new ShortUrlRequest();
        request.setUrl(shortUrl);
        return urlService.shortenUrl(request);
    }
    @GetMapping("{key}")
    public RedirectView getOriginalUrl(@PathVariable String shortUrl){
        return urlService.getFullUrl(shortUrl);
    }

    @GetMapping("/test")
    public String testApi(){
        return "Server is up";
    }
}
