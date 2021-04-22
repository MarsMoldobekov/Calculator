package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.DigitButtonTypes.*;

public class OnDigitButtonsClickListener extends OnButtonClickListener {
    public OnDigitButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                calculatorPresenter.onDigitButtonsPressed(ZERO);
                break;
            case R.id.button1:
                calculatorPresenter.onDigitButtonsPressed(ONE);
                break;
            case R.id.button2:
                calculatorPresenter.onDigitButtonsPressed(TWO);
                break;
            case R.id.button3:
                calculatorPresenter.onDigitButtonsPressed(THREE);
                break;
            case R.id.button4:
                calculatorPresenter.onDigitButtonsPressed(FOUR);
                break;
            case R.id.button5:
                calculatorPresenter.onDigitButtonsPressed(FIVE);
                break;
            case R.id.button6:
                calculatorPresenter.onDigitButtonsPressed(SIX);
                break;
            case R.id.button7:
                calculatorPresenter.onDigitButtonsPressed(SEVEN);
                break;
            case R.id.button8:
                calculatorPresenter.onDigitButtonsPressed(EIGHT);
                break;
            case R.id.button9:
                calculatorPresenter.onDigitButtonsPressed(NINE);
                break;
        }
    }
}
