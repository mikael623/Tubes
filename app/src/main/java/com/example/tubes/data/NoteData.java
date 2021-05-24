package com.example.tubes.data;

public class NoteData {
    int image;
    String judul, posted, kelas;

    public NoteData(int image, String judul, String posted, String kelas) {
        this.image = image;
        this.judul = judul;
        this.posted = posted;
        this.kelas = kelas;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
