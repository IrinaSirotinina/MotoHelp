package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        Button canadianTireBtn = (Button) findViewById(R.id.canadianTireBtn);
        canadianTireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String canTire = "https://www.canadiantire.ca/en/flyer.html";
                Uri webaddress = Uri.parse(canTire);
                Intent gotoCanTire = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoCanTire.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoCanTire);
                }
            }
        });

        Button dealsBtn = (Button) findViewById(R.id.dealsBtn);
        dealsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tires = "https://www.princessauto.com/en/current-flyer";
                Uri webaddress = Uri.parse(tires);
                Intent gotoTires = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoTires.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoTires);
                }
            }
        });

        Button maintBtn = (Button) findViewById(R.id.deals2Btn);
        maintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maint = "https://www.consumerreports.org/car-maintenance/car-maintenance-and-repair-guide/";
                Uri webaddress = Uri.parse(maint);
                Intent gotoDeals = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoDeals.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoDeals);
                }
            }
        });
    }
}
