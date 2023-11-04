package com.example.vwolt;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BatteryHealthActivity extends AppCompatActivity {
    private TextView batteryHealthText;
    private TextView alertsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_health);

        batteryHealthText = findViewById(R.id.batteryHealthText);
        alertsText = findViewById(R.id.alertsText);

        // For this example, we'll simulate updating battery health data and alerts.
        // In a real app, you would obtain this data from the EV's sensors or a remote source.
        updateBatteryHealthData(95); // Example: 95% battery health
        updateAlerts("No alerts");  // Example: No alerts
    }

    // Simulate updating battery health data
    private void updateBatteryHealthData(int healthPercentage) {
        batteryHealthText.setText("Battery Health: " + healthPercentage + "%");
    }

    // Simulate updating alerts and recommendations
    private void updateAlerts(String alerts) {
        alertsText.setText("Alerts: " + alerts);
    }
}

