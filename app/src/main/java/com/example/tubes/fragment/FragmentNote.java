package com.example.tubes.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tubes.NewNote;
import com.example.tubes.R;
import com.example.tubes.adapter.MateriAdapter;
import com.example.tubes.adapter.NoteAdapter;
import com.example.tubes.data.NoteData;
import com.example.tubes.data.NoteData;

import java.util.ArrayList;

public class FragmentNote extends Fragment {
    private RecyclerView rV_note;
    private ArrayList<NoteData> list = new ArrayList();
    private NoteAdapter adapter;
    private Button add_note;

    public FragmentNote() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        rV_note = view.findViewById(R.id.rv_list_note);
        add_note = view.findViewById(R.id.btn_createNote);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewNote.class);
                getActivity().startActivity(intent);
            }
        });

        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "7th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "8th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "7th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "9th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "8th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "7th grade"));
        list.add(new NoteData(R.drawable.ic_contact, "Vocabulary", "Admin", "7th grade"));

        adapter = new NoteAdapter(getActivity(), list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        rV_note.setLayoutManager(gridLayoutManager);
        rV_note.setAdapter(adapter);
        return view;
    }
}