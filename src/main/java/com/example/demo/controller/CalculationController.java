package com.example.demo.controller;

import com.example.demo.domain.NumberContainer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CalculationController.BASE_URL)
public class CalculationController {
    public static final String BASE_URL = "/api/v1/compute/";


//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public int add(@RequestBody int a, @RequestBody  int b) {
//        return (a+b);
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int add(@RequestBody NumberContainer numberContainer) {
        return numberContainer.add();
    }
}
