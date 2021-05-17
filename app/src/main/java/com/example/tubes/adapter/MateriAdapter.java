package com.example.tubes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.FragmentJudulMateri;
import com.example.tubes.JudulMateri;
import com.example.tubes.MainActivity4;
import com.example.tubes.R;
import com.example.tubes.data.JudulMateriData;
import com.example.tubes.data.MateriData;
import com.example.tubes.fragment.FragmentMateri;

import java.util.ArrayList;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.myViewHolder> {

    ArrayList<MateriData> list;
    Context context;

    public MateriAdapter(ArrayList<MateriData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_materi, parent, false);
        return new MateriAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.judulMateri.setText(list.get(position).getJudul());
        holder.jumlahMateri.setText(list.get(position).getJumlah());
        holder.gambar.setImageResource(list.get(position).getThumbnail());

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 AppCompatActivity activity = (AppCompatActivity)v.getContext();
//                 FragmentJudulMateri Materi = new FragmentJudulMateri();
//                 activity.getSupportFragmentManager().beginTransaction().replace(R.id.rv_list_judul_materi, Materi).addToBackStack(null).commit();

                 v.getContext().startActivity(new Intent(context, JudulMateri.class));

//                 FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
//                 fragmentTransaction.add(R.id.rv_list_judul_materi, Materi);
//                 // relativelayout_for_fragment is inside the content_main.xml
//                 fragmentTransaction.commit();

             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView judulMateri;
        TextView jumlahMateri;
        ImageView gambar;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tV_judulmateri);
            jumlahMateri = itemView.findViewById(R.id.tV_jmlhmateri);
            gambar = itemView.findViewById(R.id.iV_materi);
        }
    }
}
