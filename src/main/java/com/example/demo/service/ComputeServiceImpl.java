package com.example.demo.service;

import com.example.demo.domain.NumberContainer;
import org.springframework.stereotype.Service;

@Service
public class ComputeServiceImpl implements ComputeService {

    private final NumberContainer numberContainer;

    public ComputeServiceImpl(NumberContainer numberContainer) {
        this.numberContainer = numberContainer;
    }

    @Override
    public int add(NumberContainer numberContainer) {
        return numberContainer.add();
    }

}
