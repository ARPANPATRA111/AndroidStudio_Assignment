//MainActivity.java

package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data for the ListView
        String[] items = {
                "MCA", "M-tech", "MBA", "BCA", "B-tech",
                "MBBS", "BCS", "MS", "DCA", "CCA",
                "MCM", "PGDCA", "MOOCs", "AWS", "MSC"
        };

        // Reference to ListView
        ListView listView = findViewById(R.id.listView);

        // Adapter to connect data with ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // Built-in layout for list items
                items
        );

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Item click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = items[position];
            Toast.makeText(MainActivity.this, "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}
