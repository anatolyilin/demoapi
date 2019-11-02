package com.example.demo.domain;


import javax.validation.constraints.NotNull;

public class NumberContainer {
    @NotNull
    private String number_a;
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

    public int add() {
        return Integer.parseInt(number_a) + Integer.parseInt(number_b);
    }

}
