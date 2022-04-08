package com.github.ugolmargo.neoflexcalculator.service.impl;

import com.github.ugolmargo.neoflexcalculator.service.MathService;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    /**
     * Sum
     * @param a first
     * @param b second
     * @return sum
     */
    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double mul(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double div(Double a, Double b) {
        if(b == 0){
            throw new IllegalArgumentException("Error! Divisor cannot be 0");
        }
        return a/b;
    }
}

