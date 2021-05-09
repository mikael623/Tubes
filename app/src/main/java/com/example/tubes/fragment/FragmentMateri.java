package com.example.tubes.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
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
    private RecyclerView rv_list;
    private ArrayList<MateriData> list = new ArrayList();
    private MateriAdapter adapter;

    public FragmentMateri() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi, container, false);
        rv_list = view.findViewById(R.id.rv_list_materi);
        adapter = new MateriAdapter(list, getActivity());
        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(lm);
        rv_list.setAdapter(adapter);

        list.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "Challenger"));
        list.add(new MateriData(R.drawable.ic_logo, "Grammar", "Ranger"));
        list.add(new MateriData(R.drawable.ic_logo, "Pronoun", "Xpander Cross"));
        list.add(new MateriData(R.drawable.ic_logo, "Vocabulary", "Challenger"));
        list.add(new MateriData(R.drawable.ic_logo, "Grammar", "Ranger"));
        list.add(new MateriData(R.drawable.ic_logo, "Pronoun", "Xpander Cross"));
        return view;
    }
}