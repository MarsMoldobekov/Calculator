package com.example.calculator.presenter;

import com.example.calculator.domain.Calculator;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.ui.CalculatorView;

import static com.example.calculator.enums.DigitButtonTypes.EIGHT;
import static com.example.calculator.enums.DigitButtonTypes.FIVE;
import static com.example.calculator.enums.DigitButtonTypes.FOUR;
import static com.example.calculator.enums.DigitButtonTypes.NINE;
import static com.example.calculator.enums.DigitButtonTypes.ONE;
import static com.example.calculator.enums.DigitButtonTypes.SEVEN;
import static com.example.calculator.enums.DigitButtonTypes.SIX;
import static com.example.calculator.enums.DigitButtonTypes.THREE;
import static com.example.calculator.enums.DigitButtonTypes.TWO;
import static com.example.calculator.enums.DigitButtonTypes.ZERO;
import static com.example.calculator.enums.OperationButtonTypes.ADD;
import static com.example.calculator.enums.OperationButtonTypes.DIV;
import static com.example.calculator.enums.OperationButtonTypes.MULT;
import static com.example.calculator.enums.OperationButtonTypes.SUB;

public class CalculatorPresenter {
    private final CalculatorView calculatorView;
    private final Calculator calculator;

    public CalculatorPresenter(CalculatorView calculatorView, Calculator calculator) {
        this.calculatorView = calculatorView;
        this.calculator = calculator;
    }

    public void onDigitButtonsPressed(DigitButtonTypes type) {
        switch (type) {
            case ZERO:
                calculatorView.displayDigit(ZERO);
                calculator.onDigitButtonsPressed(ZERO);
                break;
            case ONE:
                calculatorView.displayDigit(ONE);
                calculator.onDigitButtonsPressed(ONE);
                break;
            case TWO:
                calculatorView.displayDigit(TWO);
                calculator.onDigitButtonsPressed(TWO);
                break;
            case THREE:
                calculatorView.displayDigit(THREE);
                calculator.onDigitButtonsPressed(THREE);
                break;
            case FOUR:
                calculatorView.displayDigit(FOUR);
                calculator.onDigitButtonsPressed(FOUR);
                break;
            case FIVE:
                calculatorView.displayDigit(FIVE);
                calculator.onDigitButtonsPressed(FIVE);
                break;
            case SIX:
                calculatorView.displayDigit(SIX);
                calculator.onDigitButtonsPressed(SIX);
                break;
            case SEVEN:
                calculatorView.displayDigit(SEVEN);
                calculator.onDigitButtonsPressed(SEVEN);
                break;
            case EIGHT:
                calculatorView.displayDigit(EIGHT);
                calculator.onDigitButtonsPressed(EIGHT);
                break;
            case NINE:
                calculatorView.displayDigit(NINE);
                calculator.onDigitButtonsPressed(NINE);
                break;
        }
    }

    public void onEraseButtonPressed() {
        calculatorView.erase();
        calculator.onEraseButtonPressed();
    }

    public void onOperationButtonsPressed(OperationButtonTypes type) {
        switch (type) {
            case ADD:
                calculatorView.displayOperation(calculator.onOperationButtonsPressed(ADD));
                break;
            case SUB:
                calculatorView.displayOperation(calculator.onOperationButtonsPressed(SUB));
                break;
            case MULT:
                calculatorView.displayOperation(calculator.onOperationButtonsPressed(MULT));
                break;
            case DIV:
                calculatorView.displayOperation(calculator.onOperationButtonsPressed(DIV));
                break;
        }
    }

    public void onEqualButtonPressed() {
        calculatorView.display(calculator.calculate());
    }
}