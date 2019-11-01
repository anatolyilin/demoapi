package com.example.demo.controller;

import com.example.demo.domain.NumberContainer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CalculationController.BASE_URL)
public class CalculationController {

    public static final String BASE_URL = "/api/v1/compute/";

//
//    @GetMapping("/add/{number_a}/{number_b}")
//    public int add(@PathVariable int number_a, @PathVariable int number_b){
//        return (number_a + number_b);
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int add(@RequestBody NumberContainer numberContainer) {
        return numberContainer.add();
    }
}
