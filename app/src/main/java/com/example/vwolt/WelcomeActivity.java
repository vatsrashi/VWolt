package com.example.vwolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button nextButton = findViewById(R.id.welcome_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate to the next screen (e.g., User Registration and Login)
                Intent intent = new Intent(WelcomeActivity.this, RegistrationLoginActivity.class);
                startActivity(intent);
                finish(); // Finish the current WelcomeActivity to prevent going back.
            }
        });
    }
}
