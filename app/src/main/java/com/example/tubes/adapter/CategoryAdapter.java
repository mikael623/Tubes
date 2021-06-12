package com.example.tubes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tubes.QuestionActivity;
import com.example.tubes.R;
import com.example.tubes.data.CategoryItem;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public static final String CATEGORY_COLOR = "CategoryColor";
    public static final String CATEGORY_ID = "CategoryID";
    private Context mContext;
    private ArrayList<CategoryItem> mCategoryItems;

    public CategoryAdapter(Context mContext, ArrayList<CategoryItem> mCategoryItems) {
        this.mContext = mContext;
        this.mCategoryItems = mCategoryItems;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_category_quiz_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryTitle.setText(mCategoryItems.get(position).getJudul());
        holder.categoryImage.setImageResource(mCategoryItems.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mCategoryItems.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryTitle;

        CategoryViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.imageList);
            categoryTitle = itemView.findViewById(R.id.tv_judulNote);
        }
    }

}
