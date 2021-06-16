package com.example.tubes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tubes.data.QuizData;

public class DetailQuiz extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView tv_judul = findViewById(R.id.tv_judulQuiz);
        TextView tv_jumlah = findViewById(R.id.tv_jumlahQuiz);

        QuizData quiz = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(quiz != null){
            tv_judul.setText(quiz.getJudul());
            tv_jumlah.setText(quiz.getIsi());
        }
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Quiz");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
