package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.LogarithmicFunctionTypes.LN;
import static com.example.calculator.enums.LogarithmicFunctionTypes.LOG10;
import static com.example.calculator.enums.LogarithmicFunctionTypes.LOG2;

public class OnLogarithmicFunctionButtonsClickListener extends OnButtonClickListener {
    public OnLogarithmicFunctionButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_ln:
                calculatorPresenter.onLogarithmicFunctionButtonsPressed(LN);
                break;
            case R.id.button_log2:
                calculatorPresenter.onLogarithmicFunctionButtonsPressed(LOG2);
                break;
            case R.id.button_log10:
                calculatorPresenter.onLogarithmicFunctionButtonsPressed(LOG10);
                break;
        }
    }
}
