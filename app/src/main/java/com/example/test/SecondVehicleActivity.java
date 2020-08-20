package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondVehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_vehicle);

        Button checkBtn = (Button) findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText kmText = (EditText) findViewById(R.id.kmText);
                EditText serviceDue = (EditText) findViewById(R.id.serviceDue);
                EditText serviceDue2 = (EditText) findViewById(R.id.serviceDue2);
                EditText serviceDue3 = (EditText) findViewById(R.id.serviceDue3);
                EditText serviceDue4 = (EditText) findViewById(R.id.serviceDue4);
                EditText serviceDue5 = (EditText) findViewById(R.id.serviceDue5);

                int num1 = Integer.parseInt(kmText.getText().toString());
                int service = num1 + 8000; //oil change
                int service2 = num1 + 10000; //brake inspection
                int service3 = num1 + 20000; //replace fuel filter
                int service4 = num1 + 40000; //wheel alignment
                int service5 = num1 + 100000; //timing belt replacement

                serviceDue.setText("At " + service + " km next oil change");
                serviceDue2.setText("At " + service2 + " km brake inspection");
                serviceDue3.setText("At " + service3 + " km replace fuel filter");
                serviceDue4.setText("At " + service4 + " km wheel alignment");
                serviceDue5.setText("At " + service5 + " km timing belt replacement");

            }
        });
    }
}
