package com.example.myvaksin_20200140002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myvaksin_20200140002.database.dbVaksin;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class edit_data_vaksin extends AppCompatActivity {
    TextInputEditText Nama, NIK, Ttl, Tglv, Alamat;
    Button Save;
    String nm,nik,ttl,tglv,alt,na;
    dbVaksin controller = new dbVaksin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_vaksin);

        Nama = findViewById(R.id.edinputNama);
        NIK = findViewById(R.id.edinputNIK);
        Ttl = findViewById(R.id.edinputTanggalLahir);
        Tglv = findViewById(R.id.edinputTanggalVaksin);
        Alamat = findViewById(R.id.edinputAlamat);
        Save = findViewById(R.id.edSave);

        na = getIntent().getStringExtra("na");
        nm = getIntent().getStringExtra("Nama");
        nik = getIntent().getStringExtra("NIK");
        ttl = getIntent().getStringExtra("Ttl");
        tglv = getIntent().getStringExtra("Tglv");
        alt = getIntent().getStringExtra("Alamat");

        setTitle("Edit Data");
        Nama.setText(nm);
        NIK.setText(nik);
        Ttl.setText(ttl);
        Tglv.setText(tglv);
        Alamat.setText(alt);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nama.getText().equals("")||NIK.getText().toString().equals("")||Ttl.getText().toString().equals("")||
                        Tglv.getText().toString().equals("") || Alamat.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon isi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }else {
                    nm = Nama.getText().toString();
                    nik = NIK.getText().toString();
                    ttl = Ttl.getText().toString();
                    tglv = Tglv.getText().toString();
                    alt = Alamat.getText().toString();
                    HashMap<String,String> values = new HashMap<>();
                    values.put("na",na);
                    values.put("Nama",nm);
                    values.put("NIK",nik);
                    values.put("Ttl",ttl);
                    values.put("Tglv",tglv);
                    values.put("Alamat",alt);
                    controller.UpdateData(values);
                    callData();
                }
            }
        });
    }

    private void callData() {
        Intent i = new Intent(edit_data_vaksin.this,DaftarData.class);
        startActivity(i);
        finish();
    }
}