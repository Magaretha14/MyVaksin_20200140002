package com.example.myvaksin_20200140002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myvaksin_20200140002.database.dbVaksin;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class InputDataActivity extends AppCompatActivity {
    private TextInputEditText tNama, tNIK, tTtl, tTglv, tAlamat;
    private Button simpanBtn;
    String nm,nik,ttl,tglv,alt;
    dbVaksin controller = new dbVaksin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        tNIK = (TextInputEditText) findViewById(R.id.inputNIK);
        tNama = (TextInputEditText) findViewById(R.id.inputNama);
        tTtl = (TextInputEditText) findViewById(R.id.inputTanggalLahir);
        tTglv = (TextInputEditText) findViewById(R.id.inputTanggalVaksin);
        tAlamat = (TextInputEditText) findViewById(R.id.inputAlamat);
        simpanBtn = (Button) findViewById(R.id.fabSave);


        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().equals("")||tNIK.getText().toString().equals("")||tTtl.getText().toString().equals("")||
                        tTglv.getText().toString().equals("") || tAlamat.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon isi semua data!", Toast.LENGTH_SHORT).show();
                }else {
                    nik = tNIK.getText().toString();
                    nm = tNama.getText().toString();
                    ttl = tTtl.getText().toString();
                    tglv = tTglv.getText().toString();
                    alt = tAlamat.getText().toString();

                    HashMap<String ,String> qvalues = new HashMap<>();
                    qvalues.put("NIK",nik);
                    qvalues.put("Nama",nm);
                    qvalues.put("Ttl",ttl);
                    qvalues.put("Tglv",tglv);
                    qvalues.put("Alamat",alt);

                    controller.insertData(qvalues);
                    callHome();

                }
            }
        });

    }

    public void callHome(){
        Intent intent = new Intent(InputDataActivity.this,DaftarData.class);
        startActivity(intent);
        finish();
    }

}