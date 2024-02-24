package com.example.ppdbtingkatsma;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String nama, nisn, asal, tujuan, jalur, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogForm(String nama, String nisn, String asal, String tujuan, String jalur, String key, String pilih){
        this.nama=nama;
        this.nisn=nisn;
        this.asal=asal;
        this.tujuan=tujuan;
        this.jalur=jalur;
        this.key=key;
        this.pilih=pilih;
    }
        TextView tnama,tnisn,tasal,ttujuan,tjalur;
        Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_main8, container, false);
        tnama = view.findViewById(R.id.edNama);
        tnisn = view.findViewById(R.id.edNISN);
        tasal = view.findViewById(R.id.edAsal);
        ttujuan = view.findViewById(R.id.edTujuan);
        tjalur = view.findViewById(R.id.edJalur);
        btn_simpan = view.findViewById(R.id.btn_simpan);

        tnama.setText(nama);
        tnisn.setText(nisn);
        tasal.setText(asal);
        ttujuan.setText(tujuan);
        tjalur.setText(jalur);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tnama.getText().toString();
                String nisn = tnisn.getText().toString();
                String asal = tasal.getText().toString();
                String tujuan = ttujuan.getText().toString();
                String jalur = tjalur.getText().toString();

                if (pilih.equals("Ubah")){
                    database.child("Pendaftar").child(key).setValue(new ModelPPDB(nama,nisn,asal,tujuan,jalur)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Berhasil di update", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Maaf, data gagal di update!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        }
    }
}
