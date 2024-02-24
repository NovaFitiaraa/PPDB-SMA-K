package com.example.ppdbtingkatsma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity8 extends AppCompatActivity {
    EditText edNama, edNISN, edAsal,edTujuan, edJalur;
    Button btn_simpan;
    LinearLayout back;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        edNama = findViewById(R.id.edNama);
        edNISN = findViewById(R.id.edNISN);
        edAsal = findViewById(R.id.edAsal);
        edTujuan = findViewById(R.id.edTujuan);
        edJalur = findViewById(R.id.edJalur);
        btn_simpan = findViewById(R.id.btn_simpan);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity8.this, MainActivity5.class));
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNama = edNama.getText().toString();
                String getNISN = edNISN.getText().toString();
                String getAsal = edAsal.getText().toString();
                String getTujuan = edTujuan.getText().toString();
                String getJalur = edJalur.getText().toString();

                if (getNama.isEmpty()){
                    edNama.setError("Masukkan Nama !");
                } else if (getNISN.isEmpty()) {
                    edNISN.setError("Masukkan NISN !");
                } else if (getAsal.isEmpty()) {
                    edAsal.setError("Masukkan Asal Sekolah !");
                } else if (getTujuan.isEmpty()) {
                    edTujuan.setError("Masukkan Tujuan Sekolahmu!");
                } else if (getJalur.isEmpty()) {
                    edJalur.setError("Masukkan Jalur PPDB !");
                }else {
                    database.child("Pendaftar").push().setValue(new ModelPPDB(getNama, getNISN, getAsal, getTujuan, getJalur)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(MainActivity8.this,"Data berhasil di simpan, ya !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity8.this,MainActivity9.class));
                        finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity8.this,"Data gagal di simpan !", Toast.LENGTH_SHORT).show();
                        }
                    })
                    ;
                }
            }
        });

    }
}