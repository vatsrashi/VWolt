package com.example.vwolt;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class PushNotificationsActivity extends AppCompatActivity {
    private CheckBox maintenanceNotificationsCheckBox;
    private CheckBox batteryHealthNotificationsCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifications);

        maintenanceNotificationsCheckBox = findViewById(R.id.maintenanceNotificationsCheckBox);
        batteryHealthNotificationsCheckBox = findViewById(R.id.batteryHealthNotificationsCheckBox);

        // Load user's notification settings and set the checkboxes accordingly
        // You may load saved settings and update the checkboxes here
    }

    public void saveNotificationSettings(View view) {
        // Handle saving notification settings to your app's preferences
        // You can store the user's preferences here
    }
}
