package com.example.calculator.ui.listeners;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

import static com.example.calculator.enums.IrrationalNumberTypes.E;
import static com.example.calculator.enums.IrrationalNumberTypes.PI;

public class OnIrrationalNumberButtonsClickListener extends OnButtonClickListener {
    public OnIrrationalNumberButtonsClickListener(CalculatorPresenter calculatorPresenter) {
        super(calculatorPresenter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_pi:
                calculatorPresenter.onIrrationalNumberButtonsPressed(PI);
                break;
            case R.id.button_e:
                calculatorPresenter.onIrrationalNumberButtonsPressed(E);
                break;
        }
    }
}
