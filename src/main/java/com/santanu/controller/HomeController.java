package com.santanu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    public ResponseEntity<String> homeController() {
        return new ResponseEntity<>("Welcome To TastyTracks", HttpStatus.OK);
    }
}
