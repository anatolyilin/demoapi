package com.example.demo.domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberContainerTest {

    private NumberContainer numberContainer;

    @Test
    void add() throws Exception {
        numberContainer = new NumberContainer();
        numberContainer.setNumber_a("2");
        numberContainer.setNumber_b("3");
        assertEquals(5,numberContainer.add());
    }

    @Test
    void addOverflow() throws Exception {
        numberContainer = new NumberContainer();
        numberContainer.setNumber_a("2");
        numberContainer.setNumber_b("2147483647");

        assertThrows(ArithmeticException.class, () -> {
            numberContainer.add();
        });
    }

    @Test
    void addOMalformedInput() {
        numberContainer = new NumberContainer();
        numberContainer.setNumber_a("2");
        numberContainer.setNumber_b("dc647");

        assertThrows(NumberFormatException.class, () -> {
            numberContainer.add();
        });
    }

    @Test
    void thisShouldFail(){
        assertEquals(1,2);
    }

}