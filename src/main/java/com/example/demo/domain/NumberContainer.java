package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel(description = "Object to hold and add two integers")
public class NumberContainer  {

    @ApiModelProperty(notes = "First number, String encoding accepted")
    @NotNull
    private int number_a;

    @ApiModelProperty(notes = "Second number, String encoding accepted")
    @NotNull
    private int number_b;

    public NumberContainer(@NotNull int number_a, @NotNull int number_b) {
        this.number_a = number_a;
        this.number_b = number_b;
    }

    public void setNumber_a(int number_a){
        this.number_a = number_a;
    }

    public void setNumber_b(int number_b){
        this.number_b = number_b;
    }

    public int getNumber_a(){
        return number_a;
    }

    public int getNumber_b(){
        return number_b;
    }

    // TODO: catch for integer overflow
    public int add() throws ArithmeticException {
//        System.out.println(number_a);
//        System.out.println(number_b);
        return Math.addExact(number_a , number_b);
    }

}
