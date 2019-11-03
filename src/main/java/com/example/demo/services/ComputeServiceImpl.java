package com.example.demo.services;

import com.example.demo.domain.NumberContainer;
import org.springframework.stereotype.Service;

@Service
public class ComputeServiceImpl implements ComputeService {

    @Override
    public NumberContainer add(NumberContainer numberContainer) throws Exception {
        long res = Long.parseLong(numberContainer.getNumber_a()) + Long.parseLong(numberContainer.getNumber_b());

            if (res < Integer.MAX_VALUE) {
                numberContainer.setResult( ((int) res) + "");
                return numberContainer;
            } else {
                throw new ArithmeticException("Integer overflow");
            }
    }
}
