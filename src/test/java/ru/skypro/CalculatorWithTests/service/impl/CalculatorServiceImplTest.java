package ru.skypro.CalculatorWithTests.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.CalculatorWithTests.exception.DivideByZeroException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void plus() {
        int num1 = 10;
        int num2 = 5;
        int expectedResult = 15;

        int actualResult = calculatorService.plus(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus() {
        int num1 = 10;
        int num2 = 5;
        int expectedResult = 5;

        int actualResult = calculatorService.minus(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply() {
        int num1 = 10;
        int num2 = 5;
        int expectedResult = 50;

        int actualResult = calculatorService.multiply(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide() {
        int num1 = 10;
        int num2 = 5;
        int expectedResult = 2;

        int actualResult = calculatorService.divide(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void shouldThrowExceptionWhenMun2IsZero(){
        int num1 = 10;
        int num2 = 0;

        Assertions.assertThrows(DivideByZeroException.class, () -> calculatorService.divide(num1, num2));
    }
}