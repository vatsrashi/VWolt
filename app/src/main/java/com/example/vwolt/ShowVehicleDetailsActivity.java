package com.example.vwolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowVehicleDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_vehicle_details);

        // Retrieve the vehicle details passed from the previous activity
        String makeModel = getIntent().getStringExtra("makeModel");
        String registrationNumber = getIntent().getStringExtra("registrationNumber");
        String vin = getIntent().getStringExtra("vin");
        String year = getIntent().getStringExtra("year");
        String color = getIntent().getStringExtra("color");
        String mileage = getIntent().getStringExtra("mileage");

        // Display the details in this activity
        TextView detailsTextView = findViewById(R.id.detailsTextView);
        String details = "Make and Model: " + makeModel + "\n" +
                "Registration Number: " + registrationNumber + "\n" +
                "VIN: " + vin + "\n" +
                "Year of Manufacture: " + year + "\n" +
                "Color: " + color + "\n" +
                "Mileage: " + mileage;
        detailsTextView.setText(details);

        // Find the home icon ImageView
        ImageView homeIconImageView = findViewById(R.id.homeIconImageView);

        // Set a click listener for the home icon
        homeIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the DashboardActivity
                Intent intent = new Intent(ShowVehicleDetailsActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
