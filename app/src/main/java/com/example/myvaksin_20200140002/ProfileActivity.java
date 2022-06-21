package com.example.myvaksin_20200140002;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myvaksin_20200140002.database.dbVaksin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    TextView txNama, txNik, txTtl,txTglv, txAlamat, txna;
    //protected Cursor cursor;
    String sna, snm, snik, sttl, stglv, salt;
    dbVaksin dbvksn = new dbVaksin(this);
    private ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txna = findViewById(R.id.tvna);
        txNama = findViewById(R.id.tvNama);
        txNik = findViewById(R.id.tvNik);
        txTtl = findViewById(R.id.tvTanggalLahir);
        txTglv = findViewById(R.id.tvTanggalVaksin);
        txAlamat = findViewById(R.id.tvAlamat);

        sna = getIntent().getStringExtra("na");
        snm = getIntent().getStringExtra("Nama");
        snik = getIntent().getStringExtra("NIK");
        sttl = getIntent().getStringExtra("Ttl");
        stglv = getIntent().getStringExtra("Tglv");
        salt = getIntent().getStringExtra("Alamat");

        setTitle("Lihat Data Vaksin");
        txna.setText(sna);
        txNama.setText(snm);
        txNik.setText(snik);
        txTtl.setText(sttl);
        txTglv.setText(stglv);
        txAlamat.setText(salt);

        kembali = (ImageView) findViewById(R.id.pfback);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,DaftarData.class);
                startActivity(intent);
            }
        });


    }

}