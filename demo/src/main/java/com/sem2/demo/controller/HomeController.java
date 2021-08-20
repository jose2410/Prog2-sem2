package com.sem2.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/sem2",produces = "application/json")
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saludo(@RequestParam String nombre){
        return new ResponseEntity<String>("Saludo "+nombre,HttpStatus.OK);
    }
    
}
