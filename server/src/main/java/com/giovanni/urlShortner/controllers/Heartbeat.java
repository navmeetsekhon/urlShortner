package com.giovanni.urlShortner.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
public class Heartbeat {    
    @GetMapping
    public ResponseEntity<String> heartbeat(){
        String response="Server is up and running, status : "+HttpStatus.OK.value();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping(path = "/hello", produces = "text/html")
    @ResponseBody
    public String getHello()
    {
        return "Hello World";
    }
}
