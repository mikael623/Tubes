package com.example.tubes.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tubes.CategoryActivity;
import com.example.tubes.Login;
import com.example.tubes.QuestionActivity;
import com.example.tubes.R;
import com.example.tubes.SplashScreen;

import java.util.ArrayList;

public class FragmentQuiz extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz,
                container, false);
        Button button = (Button) rootView.findViewById(R.id.btn_quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return rootView;
    }

    public void updateDetail() {
        Intent intent = new Intent(getActivity(), CategoryActivity.class);
        startActivity(intent);
    }
}