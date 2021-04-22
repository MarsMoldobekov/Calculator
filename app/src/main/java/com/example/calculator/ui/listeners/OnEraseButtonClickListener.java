package com.example.calculator.ui.listeners;

import android.view.View;

import com.example.calculator.presenter.CalculatorPresenter;

public class OnEraseButtonClickListener extends OnButtonClickListener {
    public OnEraseButtonClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @Override
    public void onClick(View v) {
        calculatorPresenter.onEraseButtonPressed();
    }
}
