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




    public FragmentMateri() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_materi, container, false);


        return view;
    }
}