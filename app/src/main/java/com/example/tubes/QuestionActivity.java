package com.example.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan kuis
    String[] pertanyaan_kuis = new String[]{
            "1. Father, mother, brother and sister are my ...",
            "2. I have a father and mother. They are my ...",
            "3. My aunt's son is my..."
    };

    //pilihan jawaban
    String[] pilihan_jawaban = new String[]{
            "parents, children, family, grandparents",
            "family, parents, children, grandparents",
            "nephew, cousin, niece, sister"
    };

    //jawaban yang benar
    String[] jawaban_benar = new String[]{
            "family",
            "parents",
            "cousin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        pertanyaan = (TextView)findViewById(R.id.kuis);
        rg = (RadioGroup)findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view ){
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById((rg.getCheckedRadioButtonId()));
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilQuiz.class);
                startActivity(selesai);

            }
        }
        else{
            Toast.makeText(this,"Pilih Jawaban Dulu", Toast.LENGTH_SHORT).show();
        }
    }
}
