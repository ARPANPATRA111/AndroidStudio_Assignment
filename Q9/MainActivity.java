// MainActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ActivityLifecycle";
    private TextView statusTextView;
    private StringBuilder lifecycleLog;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        statusTextView = findViewById(R.id.statusTextView);
        handler = new Handler();

        // Initialize or restore the log
        if (savedInstanceState != null) {
            lifecycleLog = new StringBuilder(savedInstanceState.getString("lifecycleLog", ""));
        } else {
            lifecycleLog = new StringBuilder();
        }

        // Set up buttons to trigger various lifecycle scenarios
        setupButtons();

        // Log onCreate lifecycle event
        logLifecycleEvent("onCreate");
    }

    private void setupButtons() {
        // Button to finish the activity (triggers onDestroy)
        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Button to simulate going to home screen (triggers onPause, onStop)
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });

        // Button to restart the activity (triggers full lifecycle)
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        // Button to simulate a dialog (may trigger onPause)
        Button dialogButton = findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new android.app.AlertDialog.Builder(MainActivity.this)
                        .setTitle("Lifecycle Demo")
                        .setMessage("This dialog may trigger onPause")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        // Button to clear the log
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifecycleLog = new StringBuilder();
                updateStatusText();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        logLifecycleEvent("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logLifecycleEvent("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logLifecycleEvent("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logLifecycleEvent("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logLifecycleEvent("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logLifecycleEvent("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("lifecycleLog", lifecycleLog.toString());
        logLifecycleEvent("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logLifecycleEvent("onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        logLifecycleEvent("onConfigurationChanged - " +
                (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "landscape" : "portrait"));
    }

    private void logLifecycleEvent(String event) {
        String timeStamp = String.valueOf(System.currentTimeMillis() % 10000);
        String logMessage = timeStamp + ": " + event;

        // Log to console
        Log.d(TAG, logMessage);

        // Add to our lifecycle log
        lifecycleLog.append(logMessage).append("\n");

        // Update the UI
        updateStatusText();
    }

    private void updateStatusText() {
        if (statusTextView != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    statusTextView.setText(lifecycleLog.toString());
                }
            });
        }
    }
}