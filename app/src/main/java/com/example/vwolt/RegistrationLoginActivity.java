package com.example.vwolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationLoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button registerButton = findViewById(R.id.registerButton);
        Button loginButton = findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the registration screen.
                Intent intent = new Intent(RegistrationLoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the username and password.
                String username = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin@gmail.com") && password.equals("admin12")) {
                    // Successful login, redirect to the dashboard screen.
                    Intent intent = new Intent(RegistrationLoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    // Clear the back stack so that the user can't navigate back to this login screen.
                    finish();

                } else {
                    // Display an error message for incorrect credentials.
                    Toast.makeText(RegistrationLoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Exit the app when the back button is pressed from the login screen.
        finishAffinity();
    }
}
