package com.example.personalassistant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class addworklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworklist);

        EditText etWorkTitle = findViewById(R.id.etWorkTitle);
        EditText etWorkDescription = findViewById(R.id.etWorkDescription);
        Button btnAddWork = findViewById(R.id.btnAddWork);

        btnAddWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String workTitle = etWorkTitle.getText().toString().trim();
                String workDescription = etWorkDescription.getText().toString().trim();

                if (workTitle.isEmpty() || workDescription.isEmpty()) {
                    Toast.makeText(addworklist.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Here, save the work data to a database or local storage
                    // For now, just show a Toast message
                    Toast.makeText(addworklist.this, "Work added successfully!", Toast.LENGTH_SHORT).show();

                    // Clear input fields
                    etWorkTitle.setText("");
                    etWorkDescription.setText("");
                }
            }
        });
    }
}
