package com.example.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.adapter.CategoryAdapter;
import com.example.tubes.data.CategoryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListQuiz extends AppCompatActivity {
    private RecyclerView rv_list;
    private CategoryAdapter mCategoryAdapter;
    private ArrayList<CategoryItem> mCategoryItems;
    private int[] mColors;
    private String[] mCategoryTitles;
    private String[] mCategoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

//        setUpCategoryItems();
        rv_list = findViewById(R.id.rv_list_quiz);

        mCategoryAdapter = new CategoryAdapter(this, mCategoryItems);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListQuiz.this, 2, GridLayoutManager.VERTICAL,false);
        rv_list.setLayoutManager(gridLayoutManager);
        rv_list.setAdapter(mCategoryAdapter);

    }

//    private void setUpCategoryItems() {
//        mCategoryItems = new ArrayList<>();
//        mCategoryTitles = getResources().getStringArray(R.array.category_title);
//        mCategoryID = getResources().getStringArray(R.array.category_ID);
//
//        mColors = getResources().getIntArray(R.array.colors);
//
//        for (int i = 0; i < mCategoryTitles.length; i++) {
//            mCategoryItems.add(new CategoryItem(mColors[i], mCategoryTitles[i], mCategoryID[i]));
//            Log.d("TAG", "Title\t" + mCategoryTitles[i] + "\tID\t" + mCategoryID[i]);
//        }
//    }
}
