package com.example.calculator.ui.listeners;

import android.view.View;

import com.example.calculator.presenter.CalculatorPresenter;

public class OnDeleteButtonClickListener extends OnButtonClickListener {
    public OnDeleteButtonClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @Override
    public void onClick(View v) {
        calculatorPresenter.onDeleteButtonPressed();
    }
}
