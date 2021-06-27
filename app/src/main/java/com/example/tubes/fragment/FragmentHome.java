package com.example.tubes.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tubes.Materi;
import com.example.tubes.MateriGrade8;
import com.example.tubes.MateriGrade9;
import com.example.tubes.R;
import com.google.android.material.shape.MarkerEdgeTreatment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentHome extends Fragment {
    LinearLayout class7, class8, class9;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        class7 = view.findViewById(R.id.class7);
        class8 = view.findViewById(R.id.class8);
        class9 = view.findViewById(R.id.class9);
        class7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Materi.class);
                startActivity(intent);
            }
        });
        class8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MateriGrade8.class);
                startActivity(intent);
            }
        });
        class9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MateriGrade9.class);
                startActivity(intent);
            }
        });


        return view;
    }

}