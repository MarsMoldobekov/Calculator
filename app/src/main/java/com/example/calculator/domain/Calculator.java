package com.example.calculator.domain;

import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.OperationButtonTypes;

public interface Calculator {
    void onDigitButtonsPressed(DigitButtonTypes type);
    void onEraseButtonPressed();
    String onOperationButtonsPressed(OperationButtonTypes type);
    String calculate();
}
