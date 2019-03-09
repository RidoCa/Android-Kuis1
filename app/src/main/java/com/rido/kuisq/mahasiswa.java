package com.rido.kuisq;

public class mahasiswa {

    private String nama;
    private String jurusan;
    private String nim;
    private String sosmed;

    public mahasiswa() {
    }

    public mahasiswa(String nama, String jurusan, String nim, String sosmed) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.nim = nim;
        this.sosmed = sosmed;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }
}
