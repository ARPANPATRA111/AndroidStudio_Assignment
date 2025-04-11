//MainActivity.java

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Button convertButton;
    private TextView resultTextView;

    // Conversion factor (1 kg = 2.20462 pounds)
    private static final double KG_TO_POUND = 2.20462;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        inputEditText = findViewById(R.id.inputEditText);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input value
                String inputStr = inputEditText.getText().toString();

                // Check for empty input
                if (inputStr.isEmpty()) {
                    resultTextView.setText("Please enter a value");
                    return;
                }

                // Convert kg to pounds
                try {
                    double kg = Double.parseDouble(inputStr);
                    double pounds = kg * KG_TO_POUND;
                    resultTextView.setText(String.format("%.2f kg = %.2f pounds", kg, pounds));
                } catch (NumberFormatException e) {
                    resultTextView.setText("Invalid input");
                }
            }
        });
    }
}