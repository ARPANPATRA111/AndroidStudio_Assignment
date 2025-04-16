// MainActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLength;
    private EditText editTextWidth;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextLength = findViewById(R.id.editTextLength);
        editTextWidth = findViewById(R.id.editTextWidth);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });
    }

    private void calculateArea() {
        // Get input values
        String lengthStr = editTextLength.getText().toString().trim();
        String widthStr = editTextWidth.getText().toString().trim();

        // Validate input
        if (lengthStr.isEmpty() || widthStr.isEmpty()) {
            Toast.makeText(this, "Please enter both length and width", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Parse input to double
            double length = Double.parseDouble(lengthStr);
            double width = Double.parseDouble(widthStr);

            // Calculate area
            double area = length * width;

            // Create intent to start the result activity
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("AREA", area);
            intent.putExtra("LENGTH", length);
            intent.putExtra("WIDTH", width);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}