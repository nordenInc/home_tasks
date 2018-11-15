package com.tsystems.javaschool.tasks.calculator;

import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class CalculatorImpl extends Calculator {

    private final String OPERATORS = "+-*/";
    private final String SEPARATOR = ".";
    private Stack<String> stackOperations = new Stack<>();
    private Stack<String> stackRPN = new Stack<>();
    private Stack<String> stackAnswer = new Stack<>();

    public void parseInfixToPrn(String statement) {

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
        System.out.println(stackRPN);
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
}
