package com.tsystems.javaschool.tasks.calculator;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    private final String OPERATORS = "+-*/";
    private final String SEPARATOR = ".";
    private Stack<String> stackOperations = new Stack<>();
    private Stack<String> stackRPN = new Stack<>();
    private boolean zeroDivisionCheck = true;

    public String evaluate(String statement) {

        String answer = null;

        if (checker(statement)) {
            Stack<String> prn = parseInfixToPrn(statement);
            Double calculatedResult = calculatePrn(prn);
            if (zeroDivisionCheck) {answer = rounding(calculatedResult);}
        }

        return answer;
    }

    private Stack<String> parseInfixToPrn(String statement) {

        stackRPN.clear();
        stackOperations.clear();

        if (statement.charAt(0) == '-') {
            statement = "0" + statement;
        }
        statement = statement.replace(" ", "").replace("(-", "(0-")
                .replace(",-", ",0-");

        StringTokenizer stringTokenizer = new StringTokenizer(statement,
                OPERATORS + "()", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (isSeparator(token)) {
                while (!stackOperations.empty() && !isOpenParentheses(stackOperations.lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
            } else if (isOpenParentheses(token)) {
                stackOperations.push(token);
            } else if (isCloseParentheses(token)) {
                while (!stackOperations.empty() && !isOpenParentheses(stackOperations.lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.pop();
            } else if (isNumber(token)) {
                stackRPN.push(token);

            } else if (isOperator(token)) {
                while (!stackOperations.empty() && isOperator(stackOperations.lastElement())
                        && (getPriority(token) <= getPriority(stackOperations.lastElement()))) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.push(token);
            }
        }

        while (!stackOperations.empty()) {
            stackRPN.push(stackOperations.pop());
        }

        Collections.reverse(stackRPN);

        return stackRPN;
    }

    private double calculatePrn(Stack<String> stackRPN) {

        double result = 0;
        Stack<Double> temp = new Stack<>();

        while (!stackRPN.empty()) {
            if (isNumber(stackRPN.peek())) {
                double number = Double.parseDouble(stackRPN.pop());
                temp.push(number);
            }
            if (isOperator(stackRPN.peek())) {
                double first = temp.pop();
                double second = temp.pop();

                switch (stackRPN.pop()) {
                    case "+": result = second + first; break;
                    case "-": result = second - first; break;
                    case "*": result = second * first; break;
                    case "/": {
                        if (first == 0) {
                            zeroDivisionCheck = false;}
                        result = second / first;
                        break;
                    }
                }
                temp.push(result);
            }
        }
        return temp.peek();
    }

    private String rounding(Double calculatedResult) {

        String rounded;

        if ((calculatedResult*10)%10 == 0) {
            int calculatedResultInt = calculatedResult.intValue();
            rounded = String.valueOf(calculatedResultInt);
        } else {
            DecimalFormat round = new DecimalFormat(".####");
            rounded = round.format(calculatedResult);
            rounded = rounded.replace(',','.');
        }
        return rounded;
    }

    private boolean checker(String statement) {

        int leftParentheses = 0;
        int rightParentheses = 0;
        String prevToken = "";

        StringTokenizer stringTokenizer = new StringTokenizer(statement,
                OPERATORS + SEPARATOR + "()", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (isOpenParentheses(token)) {leftParentheses++;}
            if (isCloseParentheses(token)) {rightParentheses++;}
            if (isOperator(token) && isOperator(prevToken)) {return false;}
            if (isSeparator(token) && isSeparator(prevToken)) {return false;}
            if (token.contains(",")) {return false;}
            prevToken = token;
        }

        if (leftParentheses != rightParentheses) {return false;}
        if (statement == null) {return false;}
        if (statement.equals("")) {return false;}

        return true;
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private boolean isSeparator(String token) {
        return token.equals(SEPARATOR);
    }

    private boolean isOpenParentheses(String token) {
        return token.equals("(");
    }

    private boolean isCloseParentheses(String token) {
        return token.equals(")");
    }

    private byte getPriority(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        return 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
