package com.tsystems.javaschool.tasks.calculator;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {

        //System.out.println(checkParentheses(statement));
        System.out.println(statement);
        return statement;
    }

    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.parseInfixToPrn("6.25+(7.563-5)*8");

    }

    /*
    private boolean checkParentheses(String statement) {
        int leftParentheses = 0;
        int rightParentheses = 0;
        for (int i = 0; i < statement.length(); i++ ) {
            char symbol = statement.charAt(i);
            if (symbol == '(') {
                leftParentheses++;
            } else if (symbol == ')') {
                rightParentheses++;
            }
            //System.out.println(symbol);
        }
        if (leftParentheses != rightParentheses) {
            return false;
        }
        return true;
    }
    */
}
