package com.github.ugolmargo.neoflexcalculator.controller;

import com.github.ugolmargo.neoflexcalculator.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/sum")
    public ResponseEntity<Double> sum(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.sum(a, b), HttpStatus.OK);
    }
    @GetMapping("/sub")
    public ResponseEntity<Double> sub(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.sub(a, b), HttpStatus.OK);
    }
    @GetMapping("/mul")
    public ResponseEntity<Double> mul(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.mul(a, b), HttpStatus.OK);
    }
    @GetMapping("/div")
    public ResponseEntity<Double> div(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.div(a, b), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handlerZero(HttpServletResponse httpServletResponse, IllegalArgumentException exception) throws IOException {
        httpServletResponse.setStatus(400);
        httpServletResponse.setContentType("text/plane;charset=UTF-8");
        httpServletResponse.getWriter().write(exception.getMessage());
        httpServletResponse.flushBuffer();
    }
}
