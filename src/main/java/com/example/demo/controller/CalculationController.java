package com.example.demo.controller;

import com.example.demo.domain.NumberContainer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(CalculationController.BASE_URL)
@Validated
public class CalculationController {


    public static final String BASE_URL = "/api/v1/compute/";


//    @ApiOperation(value ="GET method for adding to integers", response=Integer.class)
//    @GetMapping("/add/{number_a}/{number_b}")
//    public int add(@ApiParam(value = "First integer", required = true) @PathVariable int number_a,
//                   @ApiParam(value = "Second integer", required = true) @PathVariable int number_b){
//        return (number_a + number_b);
//    }


    @ApiOperation(value ="POST method for adding to integers or String encoded integers", response=Integer.class)
    @PostMapping("/add")
    @ResponseBody
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public int add(@org.jetbrains.annotations.NotNull @ApiParam(value = "Json object with two integer values to add", required = true) @RequestBody @Valid NumberContainer numberContainer) throws Exception {
            System.out.println(numberContainer.getNumber_a());
            System.out.println(numberContainer.getNumber_b());
            return numberContainer.add();
    }

}
