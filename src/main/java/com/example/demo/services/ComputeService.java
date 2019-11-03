package com.example.demo.services;

import com.example.demo.domain.NumberContainer;

public interface ComputeService {

    NumberContainer add(NumberContainer numberContainer) throws Exception;
//    subtract, divide, ...
}
