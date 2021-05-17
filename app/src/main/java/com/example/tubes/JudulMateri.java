package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.tubes.adapter.JudulMateriAdapter;
import com.example.tubes.data.JudulMateriData;

import java.util.ArrayList;

public class JudulMateri extends AppCompatActivity {

     RecyclerView rv_list;
     ArrayList<JudulMateriData> list = new ArrayList();
     JudulMateriAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judul_materi);

        rv_list = findViewById(R.id.rv_list_judul_materi);

        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));
        list.add(new JudulMateriData("Vocabularry"));

        rv_list.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItem = new DividerItemDecoration(this, linearLayout.getOrientation());

        rv_list.addItemDecoration(dividerItem);
        rv_list.setLayoutManager(linearLayout);
        adapter = new JudulMateriAdapter(list,this);
        rv_list.setAdapter(adapter);

    }
}