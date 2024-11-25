package ru.skypro.CalculatorWithTests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.CalculatorWithTests.exception.DivideByZeroException;
import ru.skypro.CalculatorWithTests.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting (){
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
        if(num1 == null || num2 == null){
            return "Оба аргумента обязательны";
        }
        int result = calculatorService.plus(num1, num2);
        return num1 + "+" + num2 + "=" + result;
    }

    @GetMapping("/minus")
    public String minus (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
        if(num1 == null || num2 == null) {
            return "Оба аргумента обязательны";
        }
        int result = calculatorService.minus(num1, num2);
        return num1 + "-" + num2 + "=" + result;
    }

    @GetMapping("/multiply")
    public String multiply (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
            if(num1 == null || num2 == null){
                return "Оба аргумента обязательны";
        }
        int result = calculatorService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }

    @GetMapping("/divide")
    public String divide (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
            if(num1 == null || num2 == null){
                return "Оба аргумента обязательны";
        }
            if(num2 == 0){
                throw new DivideByZeroException("Делить на ноль нельзя!");
            }
        int result = calculatorService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;
    }
}
