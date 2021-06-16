package com.example.tubes.data;

public class NoteData {

    String judul, posted, kelas,image;

    public NoteData() {
    }

    public NoteData(String judul, String posted, String kelas, String image) {
        this.judul = judul;
        this.posted = posted;
        this.kelas = kelas;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
