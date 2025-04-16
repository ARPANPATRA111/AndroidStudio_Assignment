package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewResult;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize UI components
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.buttonBack);

        // Get the area value from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double area = extras.getDouble("AREA");
            double length = extras.getDouble("LENGTH");
            double width = extras.getDouble("WIDTH");

            // Display the result
            String resultText = "Rectangle Dimensions:\n" +
                    "Length: " + length + "\n" +
                    "Width: " + width + "\n\n" +
                    "Area: " + area;
            textViewResult.setText(resultText);
        }

        // Set click listener for the back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}