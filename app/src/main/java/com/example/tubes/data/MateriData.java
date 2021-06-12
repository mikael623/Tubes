package com.example.tubes.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class MateriData implements Parcelable {
    public String judul,subjudul,deskripsi;

    public MateriData() {
    }

    public MateriData(String judul, String subjudul, String deskripsi) {
        this.judul = judul;
        this.subjudul = subjudul;
        this.deskripsi = deskripsi;
    }

    protected MateriData(Parcel in) {
        judul = in.readString();
        subjudul = in.readString();
        deskripsi = in.readString();
    }

    public static final Creator<MateriData> CREATOR = new Creator<MateriData>() {
        @Override
        public MateriData createFromParcel(Parcel in) {
            return new MateriData(in);
        }

        @Override
        public MateriData[] newArray(int size) {
            return new MateriData[size];
        }
    };

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        this.subjudul = subjudul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(subjudul);
        dest.writeString(deskripsi);
    }
}
