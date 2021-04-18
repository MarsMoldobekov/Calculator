package com.example.calculator.ui;

import com.example.calculator.enums.DigitButtonTypes;

public interface CalculatorView {
    void displayDigit(DigitButtonTypes type);
    void erase();
    void displayOperation(String expr);
    //void showResult(String result);
    void display(String expr);
}
