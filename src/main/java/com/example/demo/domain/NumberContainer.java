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

    private String result;

    public void setNumber_a(String number_a){
        this.number_a = number_a;
    }

    public void setNumber_b(String number_b){
        this.number_b = number_b;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public String getNumber_a() { return number_a; }

    public String getNumber_b(){  return number_b; }

}
