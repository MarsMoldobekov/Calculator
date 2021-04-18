package com.example.calculator.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;
import com.example.calculator.domain.CalculatorImplementation;
import com.example.calculator.enums.DigitButtonTypes;
import com.example.calculator.presenter.CalculatorPresenter;
import com.example.calculator.ui.listeners.OnDigitButtonsClickListener;
import com.example.calculator.ui.listeners.OnEqualButtonClickListener;
import com.example.calculator.ui.listeners.OnEraseButtonClickListener;
import com.example.calculator.ui.listeners.OnOperationButtonsClickListener;

public class MainActivity extends AppCompatActivity implements CalculatorView {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculatorPresenter presenter = new CalculatorPresenter(
                this, new CalculatorImplementation()
        );

        final OnDigitButtonsClickListener onDigitButtonsClickListener =
                new OnDigitButtonsClickListener(presenter);
        final OnOperationButtonsClickListener onOperationButtonsClickListener =
                new OnOperationButtonsClickListener(presenter);

        textView = findViewById(R.id.textView);

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
    }

    @Override
    public void displayDigit(DigitButtonTypes type) {
        String text = textView.getText().toString();

        switch (type) {
            case ZERO:
                text = text.concat("0");
                break;
            case ONE:
                text = text.concat("1");
                break;
            case TWO:
                text = text.concat("2");
                break;
            case THREE:
                text = text.concat("3");
                break;
            case FOUR:
                text = text.concat("4");
                break;
            case FIVE:
                text = text.concat("5");
                break;
            case SIX:
                text = text.concat("6");
                break;
            case SEVEN:
                text = text.concat("7");
                break;
            case EIGHT:
                text = text.concat("8");
                break;
            case NINE:
                text = text.concat("9");
                break;
        }

        textView.setText(text);
    }

    @Override
    public void erase() {
        textView.setText("");
    }

    @Override
    public void displayOperation(String expr) {
        textView.setText(expr);
    }

    @Override
    public void display(String expr) {
        textView.setText(expr);
    }
}