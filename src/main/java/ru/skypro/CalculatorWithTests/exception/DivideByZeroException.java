package ru.skypro.CalculatorWithTests.exception;

public class DivideByZeroException extends IllegalArgumentException{

    public DivideByZeroException(String s) {
        super(s);
    }
}
