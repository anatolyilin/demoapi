package com.example.demo.controller;

import com.example.demo.domain.NumberContainer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(CalculationController.BASE_URL)
@Validated
public class CalculationController {

    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    @Autowired
    private Environment env;

    public static final String BASE_URL = "/api/v1/compute/";

    @ApiOperation(value ="GET method for adding two integers", response=Integer.class)
    @GetMapping("/add/{number_a}/{number_b}")
    public int add(@ApiParam(value = "First integer", required = true)   @PathVariable int number_a,
                   @ApiParam(value = "Second integer", required = true)  @PathVariable int number_b){
        logger.debug(String.format("GET compute method called with %s and %s values", number_a, number_b));
        return (number_a + number_b);
    }

    @ApiOperation(value ="POST method for adding to integers or String encoded integers", response=Integer.class)
    @PostMapping(
            path="/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.ALL_VALUE}
    )

    // TODO return proper json
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String add(    @ApiParam(value = "Json object with two integer values to add", required = true)
                          @Valid
                          @RequestBody(required = true)  NumberContainer numberContainer) throws Exception {
        logger.debug(String.format("POST compute method called with %s and %s values", numberContainer.getNumber_a(), numberContainer.getNumber_b()));
        return ""+numberContainer.add();
    }

    // TODO return proper json
    @ExceptionHandler(value=ArithmeticException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleOverflowException(Exception e){
        logger.warn(env.getProperty("error.output.intoverflow"));
        return env.getProperty("error.output.intoverflow");
    }

    // TODO return proper json
    @ExceptionHandler(value=NumberFormatException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleMalformedInputException(Exception e){
        logger.warn(env.getProperty("error.input.malformednumbers"));
        return env.getProperty("error.input.malformednumbers");
    }
}
