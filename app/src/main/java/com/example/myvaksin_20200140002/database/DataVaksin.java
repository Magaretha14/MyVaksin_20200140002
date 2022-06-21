package com.example.myvaksin_20200140002.database;

public class DataVaksin {
    String Na;
    String NIK;
    String Nama;
    String Ttl;
    String Tglv;
    String Alamat;


    public DataVaksin() {
    }

    public DataVaksin(String na, String NIK, String Nama, String Ttl, String Tglv, String Alamat) {
        this.Na = na;
        this.NIK = NIK;
        this.Nama = Nama;
        this.Ttl = Ttl;
        this.Tglv = Tglv;
        this.Alamat = Alamat;
    }

    public String getNa() {
        return Na;
    }

    public void setNa(String na) {
        this.Na = na;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getTtl() {
        return Ttl;
    }

    public void setTtl(String Ttl) {
        this.Ttl = Ttl;
    }

    public String getTglv() {
        return Tglv;
    }

    public void setTglv(String Tglv) {
        this.Tglv = Tglv;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
}
