package com.example.tubes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.R;
import com.example.tubes.data.NoteData;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.myViewHolder> {
    Context context;
    ArrayList<NoteData> list;

    public NoteAdapter(Context context, ArrayList<NoteData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_note_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.judul.setText(list.get(position).getJudul());
        holder.posted.setText(list.get(position).getPosted());
        holder.kelas.setText(list.get(position).getKelas());
        holder.image.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView judul, posted, kelas;
        ImageView image;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageList);
            judul = itemView.findViewById(R.id.tv_judulNote);
            posted = itemView.findViewById(R.id.tV_posted);
            kelas = itemView.findViewById(R.id.tv_classPick);
        }
    }
}
