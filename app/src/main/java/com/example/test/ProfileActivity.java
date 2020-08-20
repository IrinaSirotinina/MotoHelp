package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener AuthStateListener;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


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

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        textView=findViewById(R.id.textView);
        toolbar=findViewById(R.id.toolbar);

        menu = navigationView.getMenu();
        menu.findItem(R.id.logout).setVisible(true);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home)
        {
            Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.email)
        {
            Intent intent = new Intent(ProfileActivity.this, EmailActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.phone)
        {
            Intent intent = new Intent(ProfileActivity.this, PhoneCallActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.map)
        {
            Intent intent = new Intent(ProfileActivity.this, MapActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.deals)
        {
            Intent intent = new Intent(ProfileActivity.this, DealsActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.logout)
        {

            Intent intent = new Intent(ProfileActivity.this, Register.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}