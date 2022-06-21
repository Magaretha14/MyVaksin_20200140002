package com.example.myvaksin_20200140002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageFldr;
    ImageView ikdaftarvaksin, ikdiagnosiscovid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFldr = findViewById(R.id.imageFolder);
        ikdaftarvaksin = findViewById(R.id.icdaftarvaksin);
        ikdiagnosiscovid = findViewById(R.id.icdiagnosiscovid);

        ikdaftarvaksin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InputDataActivity.class);
                startActivity(intent);
            }
        });

        imageFldr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DaftarData.class);
                startActivity(intent);
            }
        });

        ikdiagnosiscovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,diagnosiscovid19.class);
                startActivity(intent);
            }
        });
    }

}