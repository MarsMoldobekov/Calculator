package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.BracketButtonTypes.CLOSE;
import static com.example.calculator.enums.BracketButtonTypes.OPEN;

public class OnBracketButtonsClickListener extends OnButtonClickListener {
    public OnBracketButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_close_bracket:
                calculatorPresenter.onBracketButtonsPressed(CLOSE);
                break;
            case R.id.button_open_bracket:
                calculatorPresenter.onBracketButtonsPressed(OPEN);
                break;
        }
    }
}
