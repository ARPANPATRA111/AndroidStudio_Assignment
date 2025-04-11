//MainActivity.java

package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1EditText, num2EditText;
    private Button addButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        addButton = findViewById(R.id.addButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set onClick listener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
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

                // Convert to double and add
                try {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    double sum = num1 + num2;
                    resultTextView.setText("Result: " + sum);
                } catch (NumberFormatException e) {
                    resultTextView.setText("Invalid input");
                }
            }
        });
    }
}