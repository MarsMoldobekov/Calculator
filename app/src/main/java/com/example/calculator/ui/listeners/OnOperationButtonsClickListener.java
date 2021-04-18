package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.OperationButtonTypes.ADD;
import static com.example.calculator.enums.OperationButtonTypes.DIV;
import static com.example.calculator.enums.OperationButtonTypes.MULT;
import static com.example.calculator.enums.OperationButtonTypes.SUB;

public class OnOperationButtonsClickListener extends OnButtonClickListener {
    public OnOperationButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_plus:
                calculatorPresenter.onOperationButtonsPressed(ADD);
                break;
            case R.id.button_minus:
                calculatorPresenter.onOperationButtonsPressed(SUB);
                break;
            case R.id.button_multiply:
                calculatorPresenter.onOperationButtonsPressed(MULT);
                break;
            case R.id.button_divide:
                calculatorPresenter.onOperationButtonsPressed(DIV);
                break;
        }
    }
}
