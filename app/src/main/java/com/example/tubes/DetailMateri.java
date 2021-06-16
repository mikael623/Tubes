package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tubes.data.MateriData;

import java.util.ArrayList;
import java.util.List;

public class DetailMateri extends AppCompatActivity {
    public static final String EXTRA = "extra";
    private TextView title, deskripsi;
    private List<MateriData> listmateri;
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);
        listmateri = new ArrayList<>();

        title = findViewById(R.id.judul_materi);
        deskripsi = findViewById(R.id.isi_materi);
        gambar = findViewById(R.id.imageMateri);

        MateriData data = getIntent().getParcelableExtra(EXTRA);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            title.setText(Html.fromHtml(data.subjudul, Html.FROM_HTML_MODE_LEGACY));
            deskripsi.setText(Html.fromHtml(data.deskripsi, Html.FROM_HTML_MODE_LEGACY));
        } else {
            title.setText(Html.fromHtml(data.subjudul));
            deskripsi.setText(Html.fromHtml(data.deskripsi));
        }

//        Glide.with(this).load(data.gambar).into(gambar);
    }
}