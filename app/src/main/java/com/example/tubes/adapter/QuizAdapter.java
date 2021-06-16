package com.example.tubes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.ListQuiz;
import com.example.tubes.R;
import com.example.tubes.data.QuizData;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ListViewHolder> {
    private ArrayList<QuizData> listQuiz;

    private OnItemClickCallback onItemClickCallback;

    public  void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    public QuizAdapter(ArrayList<QuizData> list) {this.listQuiz = list;}

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_quiz_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        QuizData quiz = listQuiz.get(position);
        holder.tv_judulQuiz.setText(quiz.getJudul());
        holder.tv_jumlahQuiz.setText(quiz.getIsi());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listQuiz.get(holder.getAdapterPosition()));
            }
        });

    }

//    @Override
//    public void onBindViewHolder(@NonNull ListViewHolder holder, int position){
//        QuizData quiz = listQuiz.get(position);
//        holder.tv_judulQuiz.setText(quiz.getJudul());
//        holder.tv_jumlahQuiz.setText(quiz.getIsi());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listQuiz.get(holder.getAdapterPosition()));
//            }
//        });
//
//    }

    @Override
    public int getItemCount(){ return listQuiz.size();}

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judulQuiz;
        TextView tv_jumlahQuiz;

        ListViewHolder(View itemview) {
            super(itemview);
            tv_judulQuiz = itemview.findViewById(R.id.tv_judulQuiz);
            tv_jumlahQuiz = itemview.findViewById(R.id.tv_jumlahQuiz);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(QuizData data);
    }
}
