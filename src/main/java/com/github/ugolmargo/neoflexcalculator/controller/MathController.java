package com.github.ugolmargo.neoflexcalculator.controller;

import com.github.ugolmargo.neoflexcalculator.service.MathService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Tag(name = "Calculator")
@RestController

public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @Operation(summary = "The sum of numbers a and b", tags = "Calculator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sum a and b")
    })
    @GetMapping("/sum")
    public ResponseEntity<Double> sum(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.sum(a, b), HttpStatus.OK);
    }
    @Operation(summary = "Subtraction of the number b and the number a", tags = "Calculator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Difference a and b")
    })
    @GetMapping("/sub")
    public ResponseEntity<Double> sub(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.sub(a, b), HttpStatus.OK);
    }
    @Operation(summary = "Multiplication of numbers a and b", tags = "Calculator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product a and b")
    })
    @GetMapping("/mul")
    public ResponseEntity<Double> mul(@RequestParam Double a, @RequestParam Double b){
       return new ResponseEntity<>(mathService.mul(a, b), HttpStatus.OK);
    }
    @Operation(summary = "Dividing number a by number b", tags = "Calculator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Quotient a and b")
    })
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
