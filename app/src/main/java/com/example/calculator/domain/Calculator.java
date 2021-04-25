package com.example.calculator.domain;

import android.os.Parcelable;

import com.example.calculator.enums.BracketButtonTypes;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.IrrationalNumberTypes;
import com.example.calculator.enums.LogarithmicFunctionTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.enums.RootTypes;
import com.example.calculator.enums.TrigonometricFunctionTypes;

public interface Calculator extends Parcelable {
    String onDigitButtonsPressed(DigitButtonTypes type);
    String onBracketButtonsPressed(BracketButtonTypes type);
    String onDeleteButtonPressed();
    String onIrrationalNumberButtonsPressed(IrrationalNumberTypes type);
    String onLogarithmicFunctionButtonsPressed(LogarithmicFunctionTypes type);
    String onRootButtonsPressed(RootTypes type);
    String onTrigonometricFunctionButtonsPressed(TrigonometricFunctionTypes type);
    String onEraseButtonPressed();
    String onOperationButtonsPressed(OperationButtonTypes type);
    String onDotButtonPressed();
    String calculate();
}
