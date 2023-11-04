package com.example.vwolt;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vwolt.MaintenanceDetailsActivity;

import java.util.Calendar;

public class CustomizedMaintenanceActivity extends AppCompatActivity {
    private Spinner evMakeSpinner;
    private Spinner evModelSpinner;
    private Spinner serviceCenterSpinner; // Added Spinner for Service Center
    private String selectedMake = "";
    private String selectedModel = "";
    private String selectedServiceCenter = ""; // Added selectedServiceCenter
    private EditText selectedDateEditText;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_maintenance);

        evMakeSpinner = findViewById(R.id.evMakeSpinner);
        evModelSpinner = findViewById(R.id.evModelSpinner);
        serviceCenterSpinner = findViewById(R.id.serviceCenterSpinner);
        selectedDateEditText = findViewById(R.id.selectedDateEditText);

        // Create ArrayAdapter for EV Make Spinner
        ArrayAdapter<CharSequence> makeAdapter = ArrayAdapter.createFromResource(this, R.array.ev_make_array, android.R.layout.simple_spinner_item);
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        evMakeSpinner.setAdapter(makeAdapter);

        // Create ArrayAdapter for EV Model Spinner (initially empty)
        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        evModelSpinner.setAdapter(modelAdapter);

        // Create ArrayAdapter for Service Center Spinner (you need to define your service centers)
        ArrayAdapter<CharSequence> serviceCenterAdapter = ArrayAdapter.createFromResource(this, R.array.service_center_array, android.R.layout.simple_spinner_item);
        serviceCenterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceCenterSpinner.setAdapter(serviceCenterAdapter);

        // Set up item selection listener for EV Make Spinner
        evMakeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedMake = evMakeSpinner.getSelectedItem().toString();
                updateModelSpinner(selectedMake);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        // Set up a click listener for the generateButton
        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateMaintenanceSchedule();
            }
        });
    }

    private void updateModelSpinner(String make) {
        // Update the EV Model Spinner based on the selected make
        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (make.equals("Volkswagen")) {
            modelAdapter.addAll(getResources().getStringArray(R.array.volkswagen_models));
        } else if (make.equals("Skoda")) {
            modelAdapter.addAll(getResources().getStringArray(R.array.skoda_models));
        }else if (make.equals("Others")) {
            modelAdapter.addAll(getResources().getStringArray(R.array.others));
        } else {
            modelAdapter.add("Select Model");
        }

        evModelSpinner.setAdapter(modelAdapter);
    }

    public void showDatePickerDialog(View v) {
        // Get the current date as default in the DatePicker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                selectedYear = year;
                selectedMonth = month + 1; // Month is zero-based, so add 1
                selectedDay = day;
                selectedDateEditText.setText(selectedYear + "-" + selectedMonth + "-" + selectedDay);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void generateMaintenanceSchedule() {
        selectedModel = evModelSpinner.getSelectedItem().toString();
        String selectedDate = selectedDateEditText.getText().toString();
        selectedServiceCenter = serviceCenterSpinner.getSelectedItem().toString(); // Get the selected service center

        if (selectedMake.isEmpty() || selectedModel.isEmpty() || selectedModel.equals("Select Model") || selectedDate.isEmpty() || selectedServiceCenter.isEmpty() || selectedServiceCenter.equals("Select Center")) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // All fields are filled, continue with schedule generation

            // Implement the logic to generate a maintenance schedule
            // This can involve database queries or API calls to get recommended maintenance tasks.

            // Set up automated reminders for the maintenance tasks.
            // You can use Android's AlarmManager or a third-party scheduling library for reminders.

            // For this simplified example, we'll display a message.
            String scheduleMessage = "Maintenance schedule generated for " + selectedMake + " " + selectedModel +
                    " on " + selectedDate + " at " + selectedServiceCenter;

            // Save the user's vehicle details, selected date, and selected service center in the session (shared preferences)
            saveVehicleDetails(selectedMake, selectedModel, selectedDate, selectedServiceCenter);

            // Redirect to the MaintenanceDetailsActivity
            Intent intent = new Intent(CustomizedMaintenanceActivity.this, MaintenanceDetailsActivity.class);
            intent.putExtra("selectedMake", selectedMake);
            intent.putExtra("selectedModel", selectedModel);
            intent.putExtra("selectedDate", selectedDate);
            intent.putExtra("selectedServiceCenter", selectedServiceCenter);
            startActivity(intent);

            // Show a message to confirm the schedule generation
            Toast.makeText(this, scheduleMessage, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveVehicleDetails(String evMake, String evModel, String selectedDate, String serviceCenter) {
        // Store the user's vehicle details, selected date, and service center in shared preferences for the session
        getSharedPreferences("user_data", MODE_PRIVATE)
                .edit()
                .putString("ev_make", evMake)
                .putString("ev_model", evModel)
                .putString("selected_date", selectedDate)
                .putString("service_center", serviceCenter)
                .apply();
    }
}
