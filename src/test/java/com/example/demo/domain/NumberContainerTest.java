package com.example.demo.domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberContainerTest {

    private NumberContainer numberContainer;

    @Test
    void add() {
        numberContainer = new NumberContainer();
        numberContainer.setNumber_a(2);
        numberContainer.setNumber_b(3);
        assertEquals(5,numberContainer.add());
    }
}