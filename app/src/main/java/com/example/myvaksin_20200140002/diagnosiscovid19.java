package com.example.myvaksin_20200140002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class diagnosiscovid19 extends AppCompatActivity {

    CheckBox cbDemam, cbBatuk, cblelah, cbhilangbau,
            cbsktteng, cbsktpala, cbsktnyeri, cbdiare, cbruam,
            cbiritasi, cbsesaknapas, cbbingung, cbnyeridada;

    Button btnDiagnosa;
    ImageView dgback;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosiscovid19);

        cbDemam = findViewById(R.id.cxDemam);
        cbBatuk = findViewById(R.id.cxBatuk);
        cblelah = findViewById(R.id.cxLelah);
        cbhilangbau = findViewById(R.id.cxHilangbau);
        cbsktteng = findViewById(R.id.cxsktteng);
        cbsktpala = findViewById(R.id.cxsktpala);
        cbsktnyeri = findViewById(R.id.cxsktnyeri);
        cbdiare = findViewById(R.id.cxDiare);
        cbruam = findViewById(R.id.cxruam);
        cbiritasi = findViewById(R.id.cxiritasi);
        cbsesaknapas = findViewById(R.id.cxsesaknapas);
        cbbingung = findViewById(R.id.cxbingung);
        cbnyeridada = findViewById(R.id.cxnyeridada);

        btnDiagnosa = findViewById(R.id.btn_diagnosa);
        dgback = findViewById(R.id.dgback);
        tvResult = findViewById(R.id.tv_result);

        tvResult.setText(""); // Kosongkan TextView saat pertama kali aplikasi dijalankan


        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String JenisGejala = "Anda menderita gejala covid tingkat \n";

                // Untuk Penyakit Gastritis
                if (cbDemam.isChecked() && cbBatuk.isChecked()
                        && cblelah.isChecked() && cbhilangbau.isChecked()) {
                    JenisGejala += "paling umum";
                }
                if (cbsktteng.isChecked() && cbsktpala.isChecked()
                        && cbsktnyeri.isChecked() && cbdiare.isChecked() &&
                        cbruam.isChecked() && cbiritasi.isChecked()) {
                    JenisGejala += "Sedikit tidak umum";
                }
                if (cbsesaknapas.isChecked() && cbbingung.isChecked()
                        && cbnyeridada.isChecked()) {
                    JenisGejala += "serius";
                }
                if (cbDemam.isChecked() && cbBatuk.isChecked()
                        && cblelah.isChecked() && cbhilangbau.isChecked() && cbsktteng.isChecked() && cbsktpala.isChecked()
                        && cbsktnyeri.isChecked() && cbdiare.isChecked() &&
                        cbruam.isChecked() && cbiritasi.isChecked()) {
                    JenisGejala += " Sedikit tidak umum";
                }
                if (cbDemam.isChecked() && cbBatuk.isChecked()
                        && cblelah.isChecked() && cbhilangbau.isChecked() && cbsktteng.isChecked() && cbsktpala.isChecked()
                        && cbsktnyeri.isChecked() && cbdiare.isChecked() &&
                        cbruam.isChecked() && cbiritasi.isChecked() && cbsesaknapas.isChecked() && cbbingung.isChecked()
                        && cbnyeridada.isChecked()) {
                    JenisGejala += " Paling Serius";
                }
                // tampilkan penyakit
                tvResult.setText("" +JenisGejala);

            }
        });

        dgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diagnosiscovid19.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onClickChecked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";

        switch(view.getId()){
            case R.id.cxDemam:
                str = checked ? "Gejala Demam" : "Gejala Demam";
                break;
            case R.id.cxBatuk:
                str = checked?"Gejala Batuk" : "Gejala Batuk";
                break;
            case R.id.cxLelah:
                str = checked ? "Gejala Lelah" : "Gejala lelah";
                break;
            case R.id.cxHilangbau:
                str = checked ? "Gejala Hilang Bau" : "Gejala Hilang Bau";
                break;
            case R.id.cxsktteng:
                str = checked?"Gejala Sakit Tenggorokan" : "Gejala Sakit Tenggorokan";
                break;
            case R.id.cxsktpala:
                str = checked ? "Gejala Sakit Kepala" : "Gejala Sakit Kepala";
                break;
            case R.id.cxsktnyeri:
                str = checked ? "Gejala Rasa Nyeri" : "Gejala Rasa Nyeri";
                break;
            case R.id.cxDiare:
                str = checked ? "Gejala Sakit Diare" : "Gejala Sakit Diare";
                break;
            case R.id.cxruam:
                str = checked ? "Gejala Ruam Pada Kulit" : "Gejala Ruam Pada Kulit";
                break;
            case R.id.cxiritasi:
                str = checked?"Gejala Iritasi Pada Kulit" : "Gejala Iritasi Pada Kulit";
                break;
            case R.id.cxsesaknapas:
                str = checked ? "Gejala Sesak Nafas" : "Gejala Sesak Nafas";
                break;
            case R.id.cxbingung:
                str = checked ? "Gejala Bingung" : "Gejala Bingung";
                break;
            case R.id.cxnyeridada:
                str = checked?"Gejala Sakit Nyeri Pada Dada" : "Gejala Sakit Nyeri Pada Dada";
                break;

        }
        Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
    }

}