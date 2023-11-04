package com.example.vwolt;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MaintenanceHistoryActivity extends AppCompatActivity {
    private ListView maintenanceHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_history);

        maintenanceHistoryListView = findViewById(R.id.maintenanceHistoryListView);

        // Populate the list view with past maintenance events
        String[] maintenanceEvents = {
                "Event 1: Oil Change",
                "Event 2: Brake Inspection",
                "Event 3: Tire Rotation",
                "Event 4: Battery Replacement"
        }; // Replace with actual maintenance events

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, maintenanceEvents);
        maintenanceHistoryListView.setAdapter(adapter);
    }
}

