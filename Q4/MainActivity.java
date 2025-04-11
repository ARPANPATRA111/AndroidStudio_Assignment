//MainActivity.java

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1EditText, num2EditText;
    private Button addButton, subtractButton, multiplyButton, divideButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set click listeners
        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Get input values
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        // Check for empty inputs
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            // Perform calculation based on button clicked
            if (v.getId() == R.id.addButton) {
                result = num1 + num2;
                resultTextView.setText("Result: " + result);
            } else if (v.getId() == R.id.subtractButton) {
                result = num1 - num2;
                resultTextView.setText("Result: " + result);
            } else if (v.getId() == R.id.multiplyButton) {
                result = num1 * num2;
                resultTextView.setText("Result: " + result);
            } else if (v.getId() == R.id.divideButton) {
                if (num2 == 0) {
                    resultTextView.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                resultTextView.setText("Result: " + result);
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}