package com.github.ugolmargo.neoflexcalculator.service.impl;

import com.github.ugolmargo.neoflexcalculator.service.MathService;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    /**
     * The sum of numbers a and b
     * @param a first addend
     * @param b second addend
     * @return sum a and b
     */
    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    /**
     * Subtraction of the number b and the number a
     * @param a minuend
     * @param b subtrahend
     * @return difference a and b
     */
    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

    /**
     * Multiplication of numbers a and b
     * @param a first multiplier
     * @param b second multiplier
     * @return product a and b
     */
    @Override
    public Double mul(Double a, Double b) {
        return a * b;
    }

    /**
     * Dividing number a by number b
     * @param a dividend
     * @param b divisor
     * @return quotient a and b
     */
    @Override
    public Double div(Double a, Double b) {
        if(b == 0){
            throw new IllegalArgumentException("Error! Divisor cannot be 0");
        }
        return a/b;
    }
}

