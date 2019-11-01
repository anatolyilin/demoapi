package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Object to hold and add two integers")
public class NumberContainer {
    @ApiModelProperty(notes = "First number, String encoding accepted")
    private int number_a;
    @ApiModelProperty(notes = "Second number, String encoding accepted")
    private int number_b;

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
    public int add() {
        return number_a + number_b;
    }

}
