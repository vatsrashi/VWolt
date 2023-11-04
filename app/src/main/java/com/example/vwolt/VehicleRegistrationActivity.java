package com.example.vwolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleRegistrationActivity extends AppCompatActivity {
    private EditText makeModelEditText;
    private EditText registrationNumberEditText;
    private EditText vinEditText;
    private EditText yearEditText;
    private EditText colorEditText;
    private EditText mileageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registration);

        makeModelEditText = findViewById(R.id.makeModelEditText);
        registrationNumberEditText = findViewById(R.id.registrationNumberEditText);
        vinEditText = findViewById(R.id.vinEditText);
        yearEditText = findViewById(R.id.yearEditText);
        colorEditText = findViewById(R.id.colorEditText);
        mileageEditText = findViewById(R.id.mileageEditText);
    }

    public void uploadVehiclePhoto(View view) {
        // Handle uploading a photo of the vehicle
        // You can implement photo upload functionality here
    }

    public void saveVehicleRegistration(View view) {
        // Get the values from all EditText fields
        String makeModel = makeModelEditText.getText().toString();
        String registrationNumber = registrationNumberEditText.getText().toString();
        String vin = vinEditText.getText().toString();
        String year = yearEditText.getText().toString();
        String color = colorEditText.getText().toString();
        String mileage = mileageEditText.getText().toString();

        // Check if any of the fields are empty
        if (makeModel.isEmpty() || registrationNumber.isEmpty() || vin.isEmpty()
                || year.isEmpty() || color.isEmpty() || mileage.isEmpty()) {
            // Show an error message if any field is empty
            Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
        } else {
            // All fields are filled, continue with saving the details
            // You can store the user's vehicle details in a database or preferences here

            // Redirect to another screen to show the details
            Intent intent = new Intent(VehicleRegistrationActivity.this, ShowVehicleDetailsActivity.class);
            intent.putExtra("makeModel", makeModel);
            intent.putExtra("registrationNumber", registrationNumber);
            intent.putExtra("vin", vin);
            intent.putExtra("year", year);
            intent.putExtra("color", color);
            intent.putExtra("mileage", mileage);
            startActivity(intent);
        }
    }
}

