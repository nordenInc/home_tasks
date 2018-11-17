package com.tsystems.javaschool.tasks.calculator;

public class CalculatorImpl extends Calculator {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.evaluate("(1+38)*4-5"));
        System.out.println(calculator.evaluate("7*6/2+8"));
        System.out.println(calculator.evaluate("-12)1//("));
    }
}
