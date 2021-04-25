package com.example.calculator.domain;

import com.example.calculator.enums.BracketButtonTypes;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.IrrationalNumberTypes;
import com.example.calculator.enums.LogarithmicFunctionTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.enums.RootTypes;
import com.example.calculator.enums.TrigonometricFunctionTypes;

import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorImplementation implements Calculator {
    private final StringBuilder stringBuilder;

    public CalculatorImplementation() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public String onDigitButtonsPressed(DigitButtonTypes type) {
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

        return stringBuilder.toString();
    }

    @Override
    public String onBracketButtonsPressed(BracketButtonTypes type) {
        switch (type) {
            case CLOSE:
                stringBuilder.append(')');
                break;
            case OPEN:
                stringBuilder.append('(');
                break;
        }

        return stringBuilder.toString();
    }

    @Override
    public String onDeleteButtonPressed() {
        int length = stringBuilder.length();

        if (length > 0) {
            stringBuilder.deleteCharAt(length - 1);
        }

        return stringBuilder.toString();
    }

    @Override
    public String onIrrationalNumberButtonsPressed(IrrationalNumberTypes type) {
        switch (type) {
            case PI:
                stringBuilder.append("pi");
                break;
            case E:
                stringBuilder.append("e");
                break;
        }

        return stringBuilder.toString();
    }

    @Override
    public String onLogarithmicFunctionButtonsPressed(LogarithmicFunctionTypes type) {
        switch (type) {
            case LN:
                stringBuilder.append("log(");
                break;
            case LOG2:
                stringBuilder.append("log2(");
                break;
            case LOG10:
                stringBuilder.append("log10(");
                break;
        }

        return stringBuilder.toString();
    }

    @Override
    public String onRootButtonsPressed(RootTypes type) {
        switch (type) {
            case SQRT:
                stringBuilder.append("sqrt(");
                break;
            case CBRT:
                stringBuilder.append("cbrt(");
                break;
        }

        return stringBuilder.toString();
    }

    @Override
    public String onTrigonometricFunctionButtonsPressed(TrigonometricFunctionTypes type) {
        switch (type) {
            case COSINE:
                stringBuilder.append("cos(");
                break;
            case SINE:
                stringBuilder.append("sin(");
                break;
            case TANGENT:
                stringBuilder.append("tan(");
                break;
        }

        return stringBuilder.toString();
    }

    @Override
    public String onEraseButtonPressed() {
        stringBuilder.setLength(0);
        return stringBuilder.toString();
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
        if (isNotEmpty() && !isPreviousStringOperation()) {
            stringBuilder.append(operation);
        }

        return stringBuilder.toString();
    }

    @Override
    public String onDotButtonPressed() {
        if (isNotEmpty() && !containsDot()) {
            stringBuilder.append(".");
        }

        return stringBuilder.toString();
    }

    @Override
    public String calculate() {
        String temp = stringBuilder.toString();
        double result;

        try {
            stringBuilder.setLength(0);
            result = new ExpressionBuilder(temp).build().evaluate();
        } catch (IllegalArgumentException | ArithmeticException exception) {
            return exception.toString();
        }

        stringBuilder.append(result);
        return String.valueOf(result);
    }

    private boolean isNotEmpty() {
        return stringBuilder.length() != 0;
    }

    private boolean isPreviousStringOperation() {
        String temp = stringBuilder.toString();
        return temp.endsWith("+") || temp.endsWith("-") || temp.endsWith("*") || temp.endsWith("/");
    }

    private boolean containsDot() {
        String temp = stringBuilder.toString();
        return temp.contains(".");
    }
}