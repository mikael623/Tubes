package com.example.tubes.data;

import android.os.Parcel;
import android.os.Parcelable;

public class QuizData {
    private String id, soal,opsi1,opsi2,opsi3,opsi4,opsi5,answer;

    public QuizData() {
    }

    public QuizData(String id, String soal, String opsi1, String opsi2, String opsi3, String opsi4, String opsi5, String answer) {
        this.id = id;
        this.soal = soal;
        this.opsi1 = opsi1;
        this.opsi2 = opsi2;
        this.opsi3 = opsi3;
        this.opsi4 = opsi4;
        this.opsi5 = opsi5;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getOpsi1() {
        return opsi1;
    }

    public void setOpsi1(String opsi1) {
        this.opsi1 = opsi1;
    }

    public String getOpsi2() {
        return opsi2;
    }

    public void setOpsi2(String opsi2) {
        this.opsi2 = opsi2;
    }

    public String getOpsi3() {
        return opsi3;
    }

    public void setOpsi3(String opsi3) {
        this.opsi3 = opsi3;
    }

    public String getOpsi4() {
        return opsi4;
    }

    public void setOpsi4(String opsi4) {
        this.opsi4 = opsi4;
    }

    public String getOpsi5() {
        return opsi5;
    }

    public void setOpsi5(String opsi5) {
        this.opsi5 = opsi5;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
