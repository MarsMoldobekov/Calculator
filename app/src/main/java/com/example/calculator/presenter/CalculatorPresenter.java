package com.example.calculator.presenter;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.calculator.domain.Calculator;
import com.example.calculator.enums.BracketButtonTypes;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.enums.IrrationalNumberTypes;
import com.example.calculator.enums.LogarithmicFunctionTypes;
import com.example.calculator.enums.OperationButtonTypes;
import com.example.calculator.enums.RootTypes;
import com.example.calculator.enums.TrigonometricFunctionTypes;
import com.example.calculator.ui.CalculatorView;

public class CalculatorPresenter implements Parcelable {
    private CalculatorView calculatorView;
    private final Calculator calculator;

    public CalculatorPresenter(CalculatorView calculatorView, Calculator calculator) {
        this.calculatorView = calculatorView;
        this.calculator = calculator;
    }

    protected CalculatorPresenter(Parcel in) {
        calculator = in.readParcelable(getClass().getClassLoader());
    }

    public static final Creator<CalculatorPresenter> CREATOR = new Creator<CalculatorPresenter>() {
        @Override
        public CalculatorPresenter createFromParcel(Parcel in) {
            return new CalculatorPresenter(in);
        }

        @Override
        public CalculatorPresenter[] newArray(int size) {
            return new CalculatorPresenter[size];
        }
    };

    public void setCalculatorView(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void onDigitButtonsPressed(DigitButtonTypes type) {
        calculatorView.display(calculator.onDigitButtonsPressed(type));
    }

    public void onEraseButtonPressed() {
        calculatorView.display(calculator.onEraseButtonPressed());
    }

    public void onOperationButtonsPressed(OperationButtonTypes type) {
        calculatorView.display(calculator.onOperationButtonsPressed(type));
    }

    public void onBracketButtonsPressed(BracketButtonTypes type) {
        calculatorView.display(calculator.onBracketButtonsPressed(type));
    }

    public void onDeleteButtonPressed() {
        calculatorView.display(calculator.onDeleteButtonPressed());
    }

    public void onTrigonometricFunctionButtonsPressed(TrigonometricFunctionTypes type) {
        calculatorView.display(calculator.onTrigonometricFunctionButtonsPressed(type));
    }

    public void onLogarithmicFunctionButtonsPressed(LogarithmicFunctionTypes type) {
        calculatorView.display(calculator.onLogarithmicFunctionButtonsPressed(type));
    }

    public void onRootButtonsPressed(RootTypes type) {
        calculatorView.display(calculator.onRootButtonsPressed(type));
    }

    public void onIrrationalNumberButtonsPressed(IrrationalNumberTypes type) {
        calculatorView.display(calculator.onIrrationalNumberButtonsPressed(type));
    }

    public void onEqualButtonPressed() {
        calculatorView.display(calculator.calculate());
    }

    public void onDotButtonPressed() {
        calculatorView.display(calculator.onDotButtonPressed());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(calculator, flags);
    }
}
