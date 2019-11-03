package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Object to hold and add two integers")
public class NumberContainer {

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
                throw new ArithmeticException("Integer overflow");
            }
    }

}
