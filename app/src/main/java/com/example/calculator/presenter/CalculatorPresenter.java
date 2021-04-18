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
                calculatorView.display(calculator.onDigitButtonsPressed(ZERO));
                break;
            case ONE:
                calculatorView.display(calculator.onDigitButtonsPressed(ONE));
                break;
            case TWO:
                calculatorView.display(calculator.onDigitButtonsPressed(TWO));
                break;
            case THREE:
                calculatorView.display(calculator.onDigitButtonsPressed(THREE));
                break;
            case FOUR:
                calculatorView.display(calculator.onDigitButtonsPressed(FOUR));
                break;
            case FIVE:
                calculatorView.display(calculator.onDigitButtonsPressed(FIVE));
                break;
            case SIX:
                calculatorView.display(calculator.onDigitButtonsPressed(SIX));
                break;
            case SEVEN:
                calculatorView.display(calculator.onDigitButtonsPressed(SEVEN));
                break;
            case EIGHT:
                calculatorView.display(calculator.onDigitButtonsPressed(EIGHT));
                break;
            case NINE:
                calculatorView.display(calculator.onDigitButtonsPressed(NINE));
                break;
        }
    }

    public void onEraseButtonPressed() {
        calculatorView.display(calculator.onEraseButtonPressed());
    }

    public void onOperationButtonsPressed(OperationButtonTypes type) {
        switch (type) {
            case ADD:
                calculatorView.display(calculator.onOperationButtonsPressed(ADD));
                break;
            case SUB:
                calculatorView.display(calculator.onOperationButtonsPressed(SUB));
                break;
            case MULT:
                calculatorView.display(calculator.onOperationButtonsPressed(MULT));
                break;
            case DIV:
                calculatorView.display(calculator.onOperationButtonsPressed(DIV));
                break;
        }
    }

    public void onEqualButtonPressed() {
        calculatorView.display(calculator.calculate());
    }

    public void onDotButtonPressed() {
        calculatorView.display(calculator.onDotButtonPressed());
    }
}
