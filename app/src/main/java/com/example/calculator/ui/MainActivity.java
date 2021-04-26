package com.example.calculator.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.calculator.MainSettings;
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
    private final static String PRESENTER_KEY = "PRESENTER_KEY";
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";
    private SharedPreferences sharedPreferences;
    private CalculatorPresenter calculatorPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (savedInstanceState == null) {
            calculatorPresenter = new CalculatorPresenter(this, new CalculatorImplementation());
        } else {
            calculatorPresenter = savedInstanceState.getParcelable(PRESENTER_KEY);
            calculatorPresenter.setCalculatorView(this);
        }

        final OnDigitButtonsClickListener onDigitButtonsClickListener =
                new OnDigitButtonsClickListener(calculatorPresenter);
        final OnOperationButtonsClickListener onOperationButtonsClickListener =
                new OnOperationButtonsClickListener(calculatorPresenter);
        final OnBracketButtonsClickListener onBracketButtonsClickListener =
                new OnBracketButtonsClickListener(calculatorPresenter);

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
                new OnEraseButtonClickListener(calculatorPresenter)
        );

        findViewById(R.id.button_equal).setOnClickListener(
                new OnEqualButtonClickListener(calculatorPresenter)
        );

        findViewById(R.id.button_dot).setOnClickListener(
                new OnDotButtonClickListener(calculatorPresenter)
        );

        findViewById(R.id.button_delete).setOnClickListener(
                new OnDeleteButtonClickListener(calculatorPresenter)
        );

        if (getResources().getBoolean(R.bool.isLandscape)) {
            final OnTrigonometricFunctionButtonsClickListener onTrigonometricFunctionButtonsClickListener =
                    new OnTrigonometricFunctionButtonsClickListener(calculatorPresenter);
            final OnIrrationalNumberButtonsClickListener onIrrationalNumberButtonsClickListener =
                    new OnIrrationalNumberButtonsClickListener(calculatorPresenter);
            final OnLogarithmicFunctionButtonsClickListener onLogarithmicFunctionButtonsClickListener =
                    new OnLogarithmicFunctionButtonsClickListener(calculatorPresenter);
            final OnRootButtonsClickListener onRootButtonsClickListener =
                    new OnRootButtonsClickListener(calculatorPresenter);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(0, 1, 0, "Settings");
        menuItem.setIntent(new Intent(this, MainSettings.class));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void display(String expr) {
        textView.setText(expr);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(PRESENTER_KEY, calculatorPresenter);
        outState.putString(TEXT_VIEW_KEY, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculatorPresenter = savedInstanceState.getParcelable(PRESENTER_KEY);
        calculatorPresenter.setCalculatorView(this);
        display(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isDarkTheme = sharedPreferences.getBoolean(
                getResources().getString(R.string.switch_preference_key),
                false
        );

        if (isDarkTheme) {
            //TODO --- change theme
        } else {
            //do nothing
        }
    }
}