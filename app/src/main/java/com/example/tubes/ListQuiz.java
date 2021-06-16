package com.example.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes.adapter.CategoryAdapter;
import com.example.tubes.adapter.QuizAdapter;
import com.example.tubes.data.CategoryItem;
import com.example.tubes.data.IsiDataQuiz;
import com.example.tubes.data.QuizData;

import java.util.ArrayList;

public class ListQuiz extends AppCompatActivity {


    private RecyclerView rv_list;
    private CategoryAdapter mCategoryAdapter;
    private ArrayList<CategoryItem> mCategoryItems;
    private ArrayList<QuizData> list = new ArrayList<>();
    private int[] mColors;
    private String[] mCategoryTitles;
    private String[] mCategoryID;
    private Button kelas7,kelas8, kelas9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        kelas7 = findViewById(R.id.btn_kelas7);
        kelas8 = findViewById(R.id.btn_kelas8);
        kelas9 = findViewById(R.id.btn_kelas9);

        kelas7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListQuiz.this, KuisKelas7.class));
            }
        });

        kelas8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListQuiz.this, KuisKelas8.class));
            }
        });

        kelas9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListQuiz.this, KuisKelas9.class));
            }
        });

//        setUpCategoryItems();
//        rv_list = findViewById(R.id.rv_list_quiz);
//        rv_list.setHasFixedSize(true);

//        list.addAll(IsiDataQuiz.getListData());
//        showRecyclerList();

//        mCategoryAdapter = new CategoryAdapter(this, mCategoryItems);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListQuiz.this, 2, GridLayoutManager.VERTICAL,false);
//        rv_list.setLayoutManager(gridLayoutManager);
//        rv_list.setAdapter(mCategoryAdapter);

    }

    private void showRecyclerList(){
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        QuizAdapter quizAdapter = new QuizAdapter(list);
        rv_list.setAdapter(quizAdapter);

        quizAdapter.setOnItemClickCallback(new QuizAdapter.OnItemClickCallback(){

            @Override
            public void onItemClicked(QuizData quiz) {
                Intent moveIntent = new Intent(ListQuiz.this, DetailQuiz.class);
                moveIntent.putExtra(DetailQuiz.ITEM_EXTRA, quiz);
                startActivity(moveIntent);
            }
        });
    }







    private void setUpCategoryItems() {
        mCategoryItems = new ArrayList<CategoryItem>();
        mCategoryTitles = getResources().getStringArray(R.array.category_title);
        mCategoryID = getResources().getStringArray(R.array.category_ID);

        mColors = getResources().getIntArray(R.array.colors);

        for (int i = 0; i < mCategoryTitles.length; i++) {
            mCategoryItems.add(new CategoryItem(mColors[i], mCategoryTitles[i], mCategoryID[i]));
            Log.d("TAG", "Title\t" + mCategoryTitles[i] + "\tID\t" + mCategoryID[i]);
        }
    }
}
