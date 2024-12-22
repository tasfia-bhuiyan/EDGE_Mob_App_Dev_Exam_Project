package com.example.personalassistant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard extends AppCompatActivity {
    Button buttonLogout;
    CardView cardLocation, cardSensor, cardAddWork, cardCaptureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        buttonLogout=findViewById(R.id.buttonLogout);
        cardLocation=findViewById(R.id.cardLocation);
        cardSensor=findViewById(R.id.cardSensor);
        cardAddWork=findViewById(R.id.cardAddWork);
        cardCaptureImage=findViewById(R.id.cardCaptureImage);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,login.class);
                startActivity(intent);
                finish();
            }
        });

        cardLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("EventDashboard", "cardLocation clicked");
                Intent intent=new Intent(dashboard.this,location.class);
                startActivity(intent);
            }
        });
        cardSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,sensor.class);
                startActivity(intent);
            }
        });

        cardAddWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,addworklist.class);
                startActivity(intent);
            }
        });

        cardCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,captureimage.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}