package com.example.calculator.domain;

import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.OperationButtonTypes;

public interface Calculator {
    String onDigitButtonsPressed(DigitButtonTypes type);
    String onEraseButtonPressed();
    String onOperationButtonsPressed(OperationButtonTypes type);
    String onDotButtonPressed();
    String calculate();
}
