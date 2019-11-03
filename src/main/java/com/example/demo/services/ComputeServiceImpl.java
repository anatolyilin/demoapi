package com.example.demo.services;

import com.example.demo.domain.NumberContainer;
import org.springframework.stereotype.Service;

@Service
public class ComputeServiceImpl implements ComputeService {

    @Override
    public int add(NumberContainer numberContainer) throws Exception {
        long res = Long.parseLong(numberContainer.getNumber_a()) + Integer.parseInt(numberContainer.getNumber_b());

            if (res < Integer.MAX_VALUE) {
                return (int) res;
            } else {
                throw new ArithmeticException("Integer overflow");
            }
    }
}
