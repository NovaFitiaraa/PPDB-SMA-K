package com.example.ppdbtingkatsma;

public class ModelPPDB {
    private String nama;
    private String nisn;
    private String asal;
    private String tujuan;
    private String jalur;
    private String key;

    public ModelPPDB(){

    }

    public ModelPPDB(String nama, String nisn, String asal, String tujuan, String jalur) {
        this.nama = nama;
        this.nisn = nisn;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jalur = jalur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getJalur() {
        return jalur;
    }

    public void setJalur(String jalur) {
        this.jalur = jalur;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
