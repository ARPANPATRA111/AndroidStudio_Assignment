package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLinear = findViewById(R.id.btnLinear);
        Button btnRelative = findViewById(R.id.btnRelative);
        Button btnConstraint = findViewById(R.id.btnConstraint);
        Button btnFrame = findViewById(R.id.btnFrame);
        Button btnTable = findViewById(R.id.btnTable);

        btnLinear.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class)));
        btnRelative.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class)));
        btnConstraint.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class)));
        btnFrame.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FrameLayoutActivity.class)));
        btnTable.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TableLayoutActivity.class)));
    }
}