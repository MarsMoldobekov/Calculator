package com.example.calculator.presenter;

import com.example.calculator.domain.Calculator;
import com.example.calculator.enums.BracketButtonTypes;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.IrrationalNumberTypes;
import com.example.calculator.enums.LogarithmicFunctionTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.enums.RootTypes;
import com.example.calculator.enums.TrigonometricFunctionTypes;
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

    public void onBracketButtonsPressed(BracketButtonTypes type) {
        calculatorView.display(calculator.onBracketButtonsPressed(type));
    }

    public void onDeleteButtonPressed() {
        calculatorView.display(calculator.onDeleteButtonPressed());
    }

    public void onTrigonometricFunctionButtonsPressed(TrigonometricFunctionTypes type) {
        calculatorView.display(calculator.onTrigonometricFunctionButtonsPressed(type));
    }

    public void onLogarithmicFunctionButtonsPressed(LogarithmicFunctionTypes type) {
        calculatorView.display(calculator.onLogarithmicFunctionButtonsPressed(type));
    }

    public void onRootButtonsPressed(RootTypes type) {
        calculatorView.display(calculator.onRootButtonsPressed(type));
    }

    public void onIrrationalNumberButtonsPressed(IrrationalNumberTypes type) {
        calculatorView.display(calculator.onIrrationalNumberButtonsPressed(type));
    }

    public void onEqualButtonPressed() {
        calculatorView.display(calculator.calculate());
    }

    public void onDotButtonPressed() {
        calculatorView.display(calculator.onDotButtonPressed());
    }
}
