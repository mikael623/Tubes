package com.example.tubes.data;

public class QuizData {
    int thumbnail;
    String judul, isi;

    public QuizData(int thumbnail, String judul, String isi) {
        this.thumbnail = thumbnail;
        this.judul = judul;
        this.isi = isi;
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

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
