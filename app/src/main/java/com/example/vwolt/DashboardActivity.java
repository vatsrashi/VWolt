package com.example.vwolt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView logoutButton = findViewById(R.id.imageView7);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle logout and redirect to the registration login activity
                // You can clear user data, preferences, or perform any necessary logout actions here.
                // For the prototype, we'll simply navigate to the RegistrationLoginActivity.
                startActivity(new Intent(DashboardActivity.this, RegistrationLoginActivity.class));
                finish();
            }
        });
    }

    public void onSearchClick(View view) {
        // Implement your search functionality here
        // This method will be called when the ImageView is clicked
        // You can open a search activity or perform a search action.
    }

    @Override
    public void onBackPressed() {
        // Show a confirmation dialog when the back button is pressed
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Do you want to exit the app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Navigate to the RegistrationLoginActivity
                        startActivity(new Intent(DashboardActivity.this, RegistrationLoginActivity.class));
                        finish(); // Exit the DashboardActivity
                    }
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .show();
    }

    // Define click handlers for each feature
    public void onCustomizedMaintenanceClick(View view) {
        // Handle the click for Customized Maintenance Scheduling feature
        startActivity(new Intent(this, CustomizedMaintenanceActivity.class));
    }

    public void onDIYGuidesClick(View view) {
        // Handle the click for DIY Maintenance Guides feature
        startActivity(new Intent(this, DIYMaintenanceActivity.class));
    }

    public void onBatteryHealthClick(View view) {
        // Handle the click for Battery Health Monitoring feature
        startActivity(new Intent(this, BatteryHealthActivity.class));
    }

    public void onMaintenanceHistoryClick(View view) {
        // Handle the click for Maintenance History Tracking feature
        startActivity(new Intent(this, MaintenanceHistoryActivity.class));
    }

    public void onProfileSettingsClick(View view) {
        // Handle the click for Profile and Settings feature
        startActivity(new Intent(this, ProfileSettingsActivity.class));
    }

    public void onPushNotificationsClick(View view) {
        // Handle the click for Push Notifications feature
        startActivity(new Intent(this, PushNotificationsActivity.class));
    }

    public void onVehicleRegistrationClick(View view) {
        // Handle the click for Vehicle Registration feature
        startActivity(new Intent(this, VehicleRegistrationActivity.class));
    }
}
