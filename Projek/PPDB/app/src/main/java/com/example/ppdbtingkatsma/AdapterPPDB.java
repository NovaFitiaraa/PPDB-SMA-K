package com.example.ppdbtingkatsma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterPPDB extends RecyclerView.Adapter<AdapterPPDB.MyViewHolder> {
    private List<ModelPPDB> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterPPDB(List<ModelPPDB>mList, Activity activity){
        this.mList=mList;
        this.activity=activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelPPDB data = mList.get(position);
        holder.tv_nama.setText("Nama : "+data.getNama());
        holder.tv_nisn.setText("NISN : "+data.getNisn());
        holder.tv_asal.setText("Asal Sekolah : "+data.getAsal());
        holder.tv_tujuan.setText("Tujuan Sekolah : "+data.getTujuan());
        holder.tv_jalur.setText("Jalur PPDB : "+data.getJalur());
        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        database.child("Pendaftar").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(activity, "Data berhasil dihapus !", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity, "Data gagal disimpan !", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setMessage("Apakah anda yakin?"+data.getNama());
                builder.show();
            }
        });
        holder.card_hasil.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogForm dialog = new DialogForm(
                        data.getNama(),
                        data.getNisn(),
                        data.getAsal(),
                        data.getTujuan(),
                        data.getJalur(),
                        data.getKey(),
                        "Ubah"
                );
                dialog.show(manager, "form");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv_nama,tv_nisn,tv_asal,tv_tujuan,tv_jalur;
    CardView card_hasil;
    ImageView hapus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_nisn = itemView.findViewById(R.id.tv_nisn);
            tv_asal = itemView.findViewById(R.id.tv_asal);
            tv_tujuan = itemView.findViewById(R.id.tv_tujuan);
            tv_jalur = itemView.findViewById(R.id.tv_jalur);
            card_hasil = itemView.findViewById(R.id.card_hasil);
            hapus = itemView.findViewById(R.id.hapus);
        }
    }
}
