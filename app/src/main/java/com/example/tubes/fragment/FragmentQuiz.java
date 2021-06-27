package com.example.tubes.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tubes.ListQuiz7;
import com.example.tubes.ListQuiz8;
import com.example.tubes.ListQuiz9;
import com.example.tubes.R;

public class FragmentQuiz extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz,
                container, false);
        Button button7 = (Button) rootView.findViewById(R.id.btn_kelas7);
        Button button8 = (Button) rootView.findViewById(R.id.btn_kelas8);
        Button button9 = (Button) rootView.findViewById(R.id.btn_kelas9);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListQuiz7.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListQuiz8.class);
                startActivity(intent);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListQuiz9.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}