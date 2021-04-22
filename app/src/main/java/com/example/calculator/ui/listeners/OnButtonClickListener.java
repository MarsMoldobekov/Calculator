package com.example.calculator.ui.listeners;

import android.view.View;

import com.example.calculator.presenter.CalculatorPresenter;

public abstract class OnButtonClickListener implements View.OnClickListener {
    protected CalculatorPresenter calculatorPresenter;

    public OnButtonClickListener(CalculatorPresenter calculatorPresenter) {
        this.calculatorPresenter = calculatorPresenter;
    }
}
