package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/heartbeat")
public class Heartbeat {
    @GetMapping("/test")
    public ResponseEntity<String> heartbeat(){
        String response="Server is up and running, status : "+HttpStatus.OK.value();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
