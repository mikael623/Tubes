package com.example.tubes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.DetailMateri;
import com.example.tubes.R;
import com.example.tubes.data.JudulMateriData;

import java.util.ArrayList;

public class JudulMateriAdapter extends RecyclerView.Adapter<JudulMateriAdapter.myViewHolder> {
    ArrayList<JudulMateriData> list;
    Context context;

    public JudulMateriAdapter(ArrayList<JudulMateriData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_judul_materi, parent, false);
        return new JudulMateriAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.judulmateri.setText(list.get(position).getJudul());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AppCompatActivity activity = (AppCompatActivity)v.getContext();
//                FragmentJudulMateri Materi = new FragmentJudulMateri();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rv_list_judul_materi, Materi).addToBackStack(null).commit();
//
                v.getContext().startActivity(new Intent(context, DetailMateri.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView judulmateri;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judulmateri = itemView.findViewById(R.id.tV_list_judul_materi);
        }
    }
}
