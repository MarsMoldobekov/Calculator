package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.RootTypes.CBRT;
import static com.example.calculator.enums.RootTypes.SQRT;

public class OnRootButtonsClickListener extends OnButtonClickListener {
    public OnRootButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sqrt:
                calculatorPresenter.onRootButtonsPressed(SQRT);
                break;
            case R.id.button_cbrt:
                calculatorPresenter.onRootButtonsPressed(CBRT);
                break;
        }
    }
}
