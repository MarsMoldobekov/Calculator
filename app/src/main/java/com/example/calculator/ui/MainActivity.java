package com.example.calculator.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;
import com.example.calculator.domain.CalculatorImplementation;
import com.example.calculator.presenter.CalculatorPresenter;
import com.example.calculator.ui.listeners.OnBracketButtonsClickListener;
import com.example.calculator.ui.listeners.OnDeleteButtonClickListener;
import com.example.calculator.ui.listeners.OnDigitButtonsClickListener;
import com.example.calculator.ui.listeners.OnDotButtonClickListener;
import com.example.calculator.ui.listeners.OnEqualButtonClickListener;
import com.example.calculator.ui.listeners.OnEraseButtonClickListener;
import com.example.calculator.ui.listeners.OnIrrationalNumberButtonsClickListener;
import com.example.calculator.ui.listeners.OnLogarithmicFunctionButtonsClickListener;
import com.example.calculator.ui.listeners.OnOperationButtonsClickListener;
import com.example.calculator.ui.listeners.OnRootButtonsClickListener;
import com.example.calculator.ui.listeners.OnTrigonometricFunctionButtonsClickListener;

public class MainActivity extends AppCompatActivity implements CalculatorView {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        CalculatorPresenter presenter = new CalculatorPresenter(
                this, new CalculatorImplementation()
        );

        final OnDigitButtonsClickListener onDigitButtonsClickListener =
                new OnDigitButtonsClickListener(presenter);
        final OnOperationButtonsClickListener onOperationButtonsClickListener =
                new OnOperationButtonsClickListener(presenter);
        final OnBracketButtonsClickListener onBracketButtonsClickListener =
                new OnBracketButtonsClickListener(presenter);

        findViewById(R.id.button0).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button1).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button2).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button3).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button4).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button5).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button6).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button7).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button8).setOnClickListener(onDigitButtonsClickListener);
        findViewById(R.id.button9).setOnClickListener(onDigitButtonsClickListener);

        findViewById(R.id.button_plus).setOnClickListener(onOperationButtonsClickListener);
        findViewById(R.id.button_minus).setOnClickListener(onOperationButtonsClickListener);
        findViewById(R.id.button_multiply).setOnClickListener(onOperationButtonsClickListener);
        findViewById(R.id.button_divide).setOnClickListener(onOperationButtonsClickListener);

        findViewById(R.id.button_close_bracket).setOnClickListener(onBracketButtonsClickListener);
        findViewById(R.id.button_open_bracket).setOnClickListener(onBracketButtonsClickListener);

        findViewById(R.id.button_erase).setOnClickListener(
                new OnEraseButtonClickListener(presenter)
        );

        findViewById(R.id.button_equal).setOnClickListener(
                new OnEqualButtonClickListener(presenter)
        );

        findViewById(R.id.button_dot).setOnClickListener(
                new OnDotButtonClickListener(presenter)
        );

        findViewById(R.id.button_delete).setOnClickListener(
                new OnDeleteButtonClickListener(presenter)
        );

        if (getResources().getBoolean(R.bool.isLandscape)) {
            final OnTrigonometricFunctionButtonsClickListener onTrigonometricFunctionButtonsClickListener =
                    new OnTrigonometricFunctionButtonsClickListener(presenter);
            final OnIrrationalNumberButtonsClickListener onIrrationalNumberButtonsClickListener =
                    new OnIrrationalNumberButtonsClickListener(presenter);
            final OnLogarithmicFunctionButtonsClickListener onLogarithmicFunctionButtonsClickListener =
                    new OnLogarithmicFunctionButtonsClickListener(presenter);
            final OnRootButtonsClickListener onRootButtonsClickListener =
                    new OnRootButtonsClickListener(presenter);

            findViewById(R.id.button_cosine).setOnClickListener(onTrigonometricFunctionButtonsClickListener);
            findViewById(R.id.button_sine).setOnClickListener(onTrigonometricFunctionButtonsClickListener);
            findViewById(R.id.button_tangent).setOnClickListener(onTrigonometricFunctionButtonsClickListener);

            findViewById(R.id.button_pi).setOnClickListener(onIrrationalNumberButtonsClickListener);
            findViewById(R.id.button_e).setOnClickListener(onIrrationalNumberButtonsClickListener);

            findViewById(R.id.button_ln).setOnClickListener(onLogarithmicFunctionButtonsClickListener);
            findViewById(R.id.button_log2).setOnClickListener(onLogarithmicFunctionButtonsClickListener);
            findViewById(R.id.button_log10).setOnClickListener(onLogarithmicFunctionButtonsClickListener);

            findViewById(R.id.button_sqrt).setOnClickListener(onRootButtonsClickListener);
            findViewById(R.id.button_cbrt).setOnClickListener(onRootButtonsClickListener);
        }
    }

    @Override
    public void display(String expr) {
        textView.setText(expr);
    }
}