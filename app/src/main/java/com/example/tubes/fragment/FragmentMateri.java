package com.example.tubes.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tubes.R;
import com.example.tubes.adapter.MateriAdapter;
import com.example.tubes.data.MateriData;

import java.util.ArrayList;

public class FragmentMateri extends Fragment {

    private RecyclerView rV_materi;
    private ArrayList<MateriData> listmateri = new ArrayList();
    private MateriAdapter adaptermateri;


    public FragmentMateri() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_materi, container, false);
        rV_materi = view.findViewById(R.id.rv_list_materi);

        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));
        listmateri.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "12"));

        adaptermateri = new MateriAdapter(listmateri, getContext());

        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rV_materi.setLayoutManager(lm);
        rV_materi.setAdapter(adaptermateri);

        return view;
    }
}