package com.example.calculator.domain;

import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.OperationButtonTypes;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorImplementation implements Calculator {
    private final StringBuilder stringBuilder;

    public CalculatorImplementation() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void onDigitButtonsPressed(DigitButtonTypes type) {
        switch (type) {
            case ZERO:
                stringBuilder.append(0);
                break;
            case ONE:
                stringBuilder.append(1);
                break;
            case TWO:
                stringBuilder.append(2);
                break;
            case THREE:
                stringBuilder.append(3);
                break;
            case FOUR:
                stringBuilder.append(4);
                break;
            case FIVE:
                stringBuilder.append(5);
                break;
            case SIX:
                stringBuilder.append(6);
                break;
            case SEVEN:
                stringBuilder.append(7);
                break;
            case EIGHT:
                stringBuilder.append(8);
                break;
            case NINE:
                stringBuilder.append(9);
                break;
        }
    }

    @Override
    public void onEraseButtonPressed() {
        stringBuilder.setLength(0);
    }

    @Override
    public String onOperationButtonsPressed(OperationButtonTypes type) {
        switch (type) {
            case ADD:
                return addOperation("+");
            case SUB:
                return addOperation("-");
            case MULT:
                return addOperation("*");
            case DIV:
                return addOperation("/");
            default:
                return "";
        }
    }

    private String addOperation(String operation) {
        if (!isStringEmpty() && !isPreviousStringOperation()) {
            stringBuilder.append(operation);
        }

        return stringBuilder.toString();
    }

    private boolean isStringEmpty() {
        return stringBuilder.length() == 0;
    }

    private boolean isPreviousStringOperation() {
        String temp = stringBuilder.toString();
        return temp.endsWith("+") || temp.endsWith("-") || temp.endsWith("*") || temp.endsWith("/");
    }

    @Override
    public String calculate() {
        String temp = stringBuilder.toString();
        String result;
        Expression expression;

        try {
            stringBuilder.setLength(0);
            expression = new ExpressionBuilder(temp).build();
        } catch (IllegalArgumentException exception) {
            return exception.toString();
        }

        result = String.valueOf(expression.evaluate());
        return result;
    }
}