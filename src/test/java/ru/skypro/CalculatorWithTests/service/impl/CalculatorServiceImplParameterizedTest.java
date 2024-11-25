package ru.skypro.CalculatorWithTests.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplParameterizedTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> argumentProvider(){
        return Stream.of(
                Arguments.of(4,8),
                Arguments.of(56,8),
                Arguments.of(4,574),
                Arguments.of(87,8));

    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void plus(int num1, int num2) {

        int expectedResult = num1 + num2;

        int actualResult = calculatorService.plus(num1, num2);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
