package com.example.myvaksin_20200140002;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.myvaksin_20200140002.database.DataVaksin;
import com.example.myvaksin_20200140002.database.dbVaksin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarData extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<DataVaksin> vaksinArrayList;
    dbVaksin controller = new dbVaksin(this);
    private FloatingActionButton fab;
    private ImageView btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_data);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        btnBack = findViewById(R.id.ddback);
        BacaData();
        adapter = new DataAdapter(vaksinArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarData.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //Button untuk menyimpan data
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarData.this,InputDataActivity.class);
                startActivity(intent);
            }
        });

        //Button untuk kembali ke activity sebelumnya
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarData.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //Membaca data dari database
    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarVaksin = controller.getAllVaksin();
        vaksinArrayList = new ArrayList<>();
        //memindah dari hasil query ke dalam Teman
        for (int i=0;i<daftarVaksin.size();i++){
            DataVaksin dv = new DataVaksin();

            dv.setNa(daftarVaksin.get(i).get("na").toString());
            dv.setNIK(daftarVaksin.get(i).get("NIK").toString());
            dv.setNama(daftarVaksin.get(i).get("Nama").toString());
            dv.setTtl(daftarVaksin.get(i).get("Ttl").toString());
            dv.setTglv(daftarVaksin.get(i).get("Tglv").toString());
            dv.setAlamat(daftarVaksin.get(i).get("Alamat").toString());
            //pindahkan dari DataVaksin kedalam ArrayList teman di adapter
            vaksinArrayList.add(dv);
        }
    }
}