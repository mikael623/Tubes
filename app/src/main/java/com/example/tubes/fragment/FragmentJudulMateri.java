package com.example.tubes.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tubes.R;
import com.example.tubes.adapter.JudulMateriAdapter;
import com.example.tubes.data.JudulMateriData;

import java.util.ArrayList;


public class FragmentJudulMateri extends Fragment {

    private RecyclerView rv_list;
    private ArrayList<JudulMateriData> list = new ArrayList();
    private JudulMateriAdapter adapter;

    public FragmentJudulMateri() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_judul_materi, container, false);
        rv_list = view.findViewById(R.id.rv_list_judul_materi);

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

        adapter = new JudulMateriAdapter(list, getActivity());

        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(lm);
        rv_list.setAdapter(adapter);

        return view;
    }
}