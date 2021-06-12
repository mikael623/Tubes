package com.example.tubes.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.DetailMateri;
import com.example.tubes.JudulMateri;
import com.example.tubes.Materi;
import com.example.tubes.R;
import com.example.tubes.data.MateriData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.myViewHolder> {

    List<MateriData> list;
    Context context;

    public MateriAdapter(List<MateriData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_materi, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
//        holder.judulMateri.setText(list.get(position).judul);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.judulMateri.setText(Html.fromHtml(list.get(position).judul, Html.FROM_HTML_MODE_LEGACY));
            holder.subjudul.setText(Html.fromHtml(list.get(position).subjudul, Html.FROM_HTML_MODE_LEGACY));
            holder.deskripsi.setText(Html.fromHtml(list.get(position).deskripsi, Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.judulMateri.setText(Html.fromHtml(list.get(position).judul));
            holder.subjudul.setText(Html.fromHtml(list.get(position).subjudul));
            holder.deskripsi.setText(Html.fromHtml(list.get(position).deskripsi));
        }

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent detail = new Intent(context, DetailMateri.class);
                 detail.putExtra(DetailMateri.EXTRA, list.get(position));
                 context.startActivity(detail);
             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView judulMateri, deskripsi, subjudul;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tV_judulmateri);
            subjudul = itemView.findViewById(R.id.tV_subjudul);
            deskripsi = itemView.findViewById(R.id.tV_desc);
        }
    }
}
