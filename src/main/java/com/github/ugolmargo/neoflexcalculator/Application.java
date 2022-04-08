package com.github.ugolmargo.neoflexcalculator;

import com.github.ugolmargo.neoflexcalculator.service.MathService;
import com.github.ugolmargo.neoflexcalculator.service.impl.MathServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
