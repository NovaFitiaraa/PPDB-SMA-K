package com.example.ppdbtingkatsma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {
    Button btnhome, btncari, btnuser, btncontact, buat, lihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btnhome = findViewById(R.id.btnhome);
        btncari = findViewById(R.id.btncari);
        btnuser = findViewById(R.id.btnuser);
        btncontact = findViewById(R.id.btncontact);
        lihat = findViewById(R.id.buat);
        buat = findViewById(R.id.lihat);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity3.class));
            }
        });
        btncari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity4.class));
            }
        });
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity5.class));
            }
        });
        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity6.class));
            }
        });
        buat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity9.class));
            }
        });
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity5.this, MainActivity8.class));
            }
        });
    }
}