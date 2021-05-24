package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tubes.adapter.MateriAdapter;
import com.example.tubes.data.MateriData;

import java.util.ArrayList;

public class Materi extends AppCompatActivity {
    private RecyclerView rV_materi;
    private ArrayList<MateriData> listmateri = new ArrayList();
    private MateriAdapter adaptermateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        rV_materi = findViewById(R.id.rv_list_materi);

        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_contact, "Vocabulary", "12"));

        adaptermateri = new MateriAdapter(listmateri, this);

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rV_materi.setLayoutManager(lm);
        rV_materi.setAdapter(adaptermateri);
    }
}