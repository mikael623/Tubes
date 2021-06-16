package com.example.tubes.data;

import android.os.Parcel;
import android.os.Parcelable;

public class QuizData implements Parcelable {
    private String judul;
    private String isi;

    public QuizData(){

    }

    public QuizData(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    protected QuizData(Parcel in) {
        judul = in.readString();
        isi = in.readString();
    }

    public static final Creator<QuizData> CREATOR = new Creator<QuizData>() {
        @Override
        public QuizData createFromParcel(Parcel in) {
            return new QuizData(in);
        }

        @Override
        public QuizData[] newArray(int size) {
            return new QuizData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(isi);
    }
}
