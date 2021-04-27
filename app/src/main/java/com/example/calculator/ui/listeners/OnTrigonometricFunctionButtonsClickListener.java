package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.TrigonometricFunctionTypes.COSINE;
import static com.example.calculator.enums.TrigonometricFunctionTypes.SINE;
import static com.example.calculator.enums.TrigonometricFunctionTypes.TANGENT;

public class OnTrigonometricFunctionButtonsClickListener extends OnButtonClickListener {
    public OnTrigonometricFunctionButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sine:
                calculatorPresenter.onTrigonometricFunctionButtonsPressed(SINE);
                break;
            case R.id.button_cosine:
                calculatorPresenter.onTrigonometricFunctionButtonsPressed(COSINE);
                break;
            case R.id.button_tangent:
                calculatorPresenter.onTrigonometricFunctionButtonsPressed(TANGENT);
                break;
        }
    }
}
