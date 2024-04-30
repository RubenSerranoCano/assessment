package com.rserrano.assessment.adapters.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rserrano.assessment.constants.ApiConstants.API_V1_PREFIX;

@RestController
@RequestMapping(API_V1_PREFIX)
public class PriceController {

    @GetMapping("/hello-world")
    ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Greetings!");
    }

}
