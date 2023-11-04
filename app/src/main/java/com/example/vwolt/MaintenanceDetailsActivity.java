package com.example.vwolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MaintenanceDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_details);

        // Retrieve data passed from CustomizedMaintenanceActivity
        String selectedMake = getIntent().getStringExtra("selectedMake");
        String selectedModel = getIntent().getStringExtra("selectedModel");
        String selectedDate = getIntent().getStringExtra("selectedDate");
        String selectedServiceCenter = getIntent().getStringExtra("selectedServiceCenter");

        // Display the details in this activity
        TextView detailsTextView = findViewById(R.id.detailsTextView);
        String details = "Make: " + selectedMake + "\n" +
                "Model: " + selectedModel + "\n" +
                "Service Center: " + selectedServiceCenter + "\n" +
                "Scheduled Date: " + selectedDate;
        detailsTextView.setText(details);

        // Find the home icon ImageView
        ImageView homeIconImageView = findViewById(R.id.homeIconImageView);

        // Set a click listener for the home icon
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the DashboardActivity
                Intent intent = new Intent(MaintenanceDetailsActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}

