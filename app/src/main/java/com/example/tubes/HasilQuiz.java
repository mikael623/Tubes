package com.example.tubes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class HasilQuiz extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_quiz);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar :"+QuestionActivity.benar+"\nJawaban Salah :"+QuestionActivity.salah);
        nilai.setText(""+QuestionActivity.hasil);
    }

    public void ulangi(View view){
        finish();
        Intent i = new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(i);
    }
}
