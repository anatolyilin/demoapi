package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Object to hold and add two integers")
public class NumberContainer {

    Logger logger = LoggerFactory.getLogger(NumberContainer.class);

    @ApiModelProperty(notes = "First number, String encoding accepted")
    @NotNull
    private String number_a;

    @ApiModelProperty(notes = "Second number, String encoding accepted")
    @NotNull
    private String number_b;

    public void setNumber_a(String number_a){
        this.number_a = number_a;
    }

    public void setNumber_b(String number_b){
        this.number_b = number_b;
    }

    public String getNumber_a(){
        return number_a;
    }

    public String getNumber_b(){
        return number_b;
    }

    public int add() throws Exception {
            long res = Long.parseLong(number_a) + Long.parseLong(number_b);
            if (res < Integer.MAX_VALUE) {
                return (int) res;
            } else {
                logger.error(String.format("Input values %s and %s cause integer overflow for add method", number_a, number_b));
                throw new ArithmeticException("Integer overflow");
            }
    }

}
