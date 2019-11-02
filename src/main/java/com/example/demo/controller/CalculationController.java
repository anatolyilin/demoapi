package com.example.demo.controller;

import com.example.demo.domain.NumberContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(CalculationController.BASE_URL)
@Validated
public class CalculationController {
    public static final String BASE_URL = "/api/v1/compute/";


    @GetMapping("/add/{number_a}/{number_b}")
    public int add(@PathVariable int number_a, @PathVariable int number_b){
        return (number_a + number_b);
    }

//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(
            path="/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.ALL_VALUE}
    )
    public String add(@Valid @RequestBody(required = true)  NumberContainer numberContainer) {
        return ""+numberContainer.add();
    }
}
