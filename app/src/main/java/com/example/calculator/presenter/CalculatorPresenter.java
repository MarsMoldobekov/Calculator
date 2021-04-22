package com.example.calculator.presenter;

import com.example.calculator.domain.Calculator;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.ui.CalculatorView;

public class CalculatorPresenter {
    private final CalculatorView calculatorView;
    private final Calculator calculator;

    public CalculatorPresenter(CalculatorView calculatorView, Calculator calculator) {
        this.calculatorView = calculatorView;
        this.calculator = calculator;
    }

    public void onDigitButtonsPressed(DigitButtonTypes type) {
        calculatorView.display(calculator.onDigitButtonsPressed(type));
    }

    public void onEraseButtonPressed() {
        calculatorView.display(calculator.onEraseButtonPressed());
    }

    public void onOperationButtonsPressed(OperationButtonTypes type) {
        calculatorView.display(calculator.onOperationButtonsPressed(type));
    }

    public void onEqualButtonPressed() {
        calculatorView.display(calculator.calculate());
    }

    public void onDotButtonPressed() {
        calculatorView.display(calculator.onDotButtonPressed());
    }
}
