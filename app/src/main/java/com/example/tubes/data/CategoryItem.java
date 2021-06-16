package com.example.tubes.data;

public class CategoryItem {
    private int image;
    private String Judul;

    public CategoryItem(int image, String mCategoryTitle, String judul) {
        this.image = image;
        Judul = judul;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public int getIsi() {
        return 0;
    }
}
