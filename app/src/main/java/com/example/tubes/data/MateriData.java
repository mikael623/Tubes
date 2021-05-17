package com.example.tubes.data;

import android.widget.ImageView;

public class MateriData {
    int thumbnail;
    String judul, jumlah;

    public MateriData() {
    }

    public MateriData(int thumbnail, String judul, String jumlah) {
        this.thumbnail = thumbnail;
        this.judul = judul;
        this.jumlah = jumlah;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
