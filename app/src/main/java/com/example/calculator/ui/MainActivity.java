package com.example.calculator.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;
import com.example.calculator.domain.CalculatorImplementation;
import com.example.calculator.presenter.CalculatorPresenter;
import com.example.calculator.ui.listeners.OnDigitButtonsClickListener;
import com.example.calculator.ui.listeners.OnDotButtonClickListener;
import com.example.calculator.ui.listeners.OnEqualButtonClickListener;
import com.example.calculator.ui.listeners.OnEraseButtonClickListener;
import com.example.calculator.ui.listeners.OnOperationButtonsClickListener;

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

        findViewById(R.id.button_erase).setOnClickListener(
                new OnEraseButtonClickListener(presenter)
        );

        findViewById(R.id.button_equal).setOnClickListener(
                new OnEqualButtonClickListener(presenter)
        );

        findViewById(R.id.button_dot).setOnClickListener(
                new OnDotButtonClickListener(presenter)
        );
    }

    @Override
    public void display(String expr) {
        textView.setText(expr);
    }
}