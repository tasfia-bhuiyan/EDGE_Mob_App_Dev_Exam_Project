package com.example.personalassistant;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.personalassistant.R;

public class sensor extends AppCompatActivity implements SensorEventListener {

    TextView text, text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sensor);

        text =findViewById(R.id.text);
        text1 =findViewById(R.id.text1);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            Sensor direction= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(direction!=null){
                sensorManager.registerListener(this, direction, SensorManager.SENSOR_DELAY_NORMAL);
            }
            Sensor direction1= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(direction1!=null){
                sensorManager.registerListener(this, direction1, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            text.setText("X"+sensorEvent.values[0]+"Y"+sensorEvent.values[1]+"Z"+sensorEvent.values[0]);
        }
        if (sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
            if (sensorEvent.values[0]<0){
                text1.setText("Light Sensor low"+sensorEvent.values[0]);
            }


            else {
                text1.setText("Light Sensor high"+sensorEvent.values[0]);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }



}