package com.example.vwolt;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DIYMaintenanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_maintenance);

        // Populate the list view with available DIY maintenance guides
        ListView diyGuidesListView = findViewById(R.id.diyGuidesListView);

        String[] guides = {"Guide 1", "Guide 2", "Guide 3"}; // Replace with your guide titles
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, guides);
        diyGuidesListView.setAdapter(adapter);

        // Set a click listener for guide selection
        diyGuidesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle guide selection, e.g., open the selected guide's content
                String selectedGuide = guides[position];
                Toast.makeText(DIYMaintenanceActivity.this, "Selected: " + selectedGuide, Toast.LENGTH_SHORT).show();
                // In a real app, you'd navigate to the guide content screen.
            }
        });
    }
}

