package com.example.demo.domain;


public class TwoNumberContainer implements NumberContainer {

    private int number_a;
    private int number_b;

    public int getNumber_a() {
        return number_a;
    }

    public void setNumber_a(int number_a) {
        this.number_a = number_a;
    }

    public int getNumber_b() {
        return number_b;
    }

    public void setNumber_b(int number_b) {
        this.number_b = number_b;
    }

    @Override
    public int add() {
        return number_a+number_b;
    }
}
