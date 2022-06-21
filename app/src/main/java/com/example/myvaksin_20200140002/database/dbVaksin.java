package com.example.myvaksin_20200140002.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class dbVaksin extends SQLiteOpenHelper {
    //Membuat database di SQLite
    public dbVaksin(Context context) {
        super(context, "VaksinDatabaseYo", null, 1);
    }

    //Membuat tabel pada databse "VaksinDatabaseYo"
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table vaksinapp (na integer primary key,NIK text, Nama text, Ttl text, Tglv text, Alamat text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists vaksinapp");
        onCreate(db);

    }

    //Memasukkan data ke database
    public void insertData(HashMap<String,String> queryValues){
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("NIK",queryValues.get("NIK"));
        nilai.put("Nama",queryValues.get("Nama"));
        nilai.put("Ttl",queryValues.get("Ttl"));
        nilai.put("Tglv",queryValues.get("Tglv"));
        nilai.put("Alamat",queryValues.get("Alamat"));
        basisdata.insert("vaksinapp",null,nilai);
        basisdata.close();
    }

    //Mengedit data di database
    public void UpdateData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("NIK",queryValues.get("NIK"));
        nilai.put("Nama",queryValues.get("Nama"));
        nilai.put("Ttl",queryValues.get("Ttl"));
        nilai.put("Tglv",queryValues.get("Tglv"));
        nilai.put("Alamat",queryValues.get("Alamat"));
        db.update("vaksinapp", nilai,"na=?",new String[]{queryValues.get("na")});
        db.close();
    }

    //Menghapus data di database
    public void DeleteData(HashMap<String,String> queryValue){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("vaksinapp","na=?",new String[]{queryValue.get("na")});
        db.close();
    }

    //Menampilkan data
    public ArrayList<HashMap<String,String>> getAllVaksin(){
        ArrayList<HashMap<String,String>> daftarVaksin;
        daftarVaksin = new ArrayList<>();
        String selectQuery = "Select * from vaksinapp";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("na", cursor.getString(0));
                map.put("NIK", cursor.getString(1));
                map.put("Nama", cursor.getString(2));
                map.put("Ttl", cursor.getString(3));
                map.put("Tglv", cursor.getString(4));
                map.put("Alamat", cursor.getString(5));
                daftarVaksin.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarVaksin;
    }
}