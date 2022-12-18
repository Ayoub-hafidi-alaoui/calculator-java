package com.android.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    TextView result_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result_tv = findViewById(R.id.result_tv);

    }

    public void onDigitClick(View view) {
        Button clickedButton = (Button) view;
        Log.e("calculator activity", "button was clicked");
        Log.e("result text view", result_tv.toString());
        result_tv.append(clickedButton.getText());
    }

    String lhs = "";
    String operator = "";

    public void OnOperatorClick(View view) {
        lhs = result_tv.getText().toString();
        Button clickedOperator = (Button) view;
        if (operator.isEmpty()) {
            operator = clickedOperator.getText().toString();
            result_tv.setText(null);
        } else {
            lhs = calculate(lhs, operator, result_tv.getText().toString());
            operator = clickedOperator.getText().toString();
            result_tv.setText(null);


        }
        Log.e("on operator click", "lhs: " + lhs + "\n operator: " + operator);
    }

    public String calculate(String lhs, String operator, String rhs) {
        Double leftHandSide = Double.parseDouble(lhs);
        Double rightHandSide = Double.parseDouble(rhs);
        if (operator.equals("+")) {
            Double result = leftHandSide + rightHandSide;
            return result.toString();
        } else if (operator.equals("-")) {
            Double result = leftHandSide - rightHandSide;
            return result.toString();
        } else if (operator.equals("X")) {
            Double result = leftHandSide * rightHandSide;
            return result.toString();
        } else if (operator.equals("/")) {
            Double result = leftHandSide / rightHandSide;
            return result.toString();
        }
        return null;
    }

    public void onEqualClick(View view) {
        String result = calculate(lhs, operator, result_tv.getText().toString());
        result_tv.setText(result);
        lhs = "";
        operator = "";
    }
}