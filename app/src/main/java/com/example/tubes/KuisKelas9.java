package com.example.tubes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tubes.data.KumpulanSoalKelas7;
import com.example.tubes.data.KumpulanSoalKelas9;
import com.example.tubes.data.QuizData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KuisKelas9 extends AppCompatActivity {

    TextView txtNo, txtWaktu, txtSoal, txtCount;
    Button btnSelesai;
    ImageButton btnPrev, btnNext;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    int jawabanYgDiPilih[] = null;
    int jawabanYgBenar[] = null;
    boolean cekPertanyaan = false;
    int urutanPertanyaan = 0;
    List<QuizData> listSoal;
    JSONArray soal = null;
    CounterClass mCountDownTimer;
    private ProgressDialog pDialog;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    //TODO : Ubah database dengan IP Address kalian
    private static String myURL = "http://192.168.43.246/database/get_data_soalsembilan.php";
    private static final String TAG_DAFTAR = "daftar_soal";
    private static final String TAG_ID = "id";
    private static final String TAG_SOAL = "soal";
    private static final String TAG_A = "a";
    private static final String TAG_B = "b";
    private static final String TAG_C = "c";
    private static final String TAG_D = "d";
    private static final String TAG_E = "e";
    private static final String TAG_JWB = "correct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_kelas9);
        listSoal = new ArrayList<QuizData>();
        txtNo = (TextView) findViewById(R.id.textViewNo);
        txtWaktu = (TextView) findViewById(R.id.textViewWaktu);
        txtSoal = (TextView) findViewById(R.id.textViewSoal);
        txtCount = (TextView) findViewById(R.id.textViewCount);
        btnPrev = (ImageButton) findViewById(R.id.buttonPrev);
        btnSelesai = (Button) findViewById(R.id.buttonSelesai);
        btnNext = (ImageButton) findViewById(R.id.buttonNext);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rb1 = (RadioButton) findViewById(R.id.radio0);
        rb2 = (RadioButton) findViewById(R.id.radio1);
        rb3 = (RadioButton) findViewById(R.id.radio2);
        rb4 = (RadioButton) findViewById(R.id.radio3);
        rb5 = (RadioButton) findViewById(R.id.radio4);

        btnSelesai.setOnClickListener(klikSelesai);
        btnPrev.setOnClickListener(klikSebelum);
        btnNext.setOnClickListener(klikBerikut);
        new GetSoal().execute();
    }

    private class GetSoal extends AsyncTask<String, String, String> {
        ProgressDialog pb = new ProgressDialog(KuisKelas9.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL(myURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            }
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");
                conn.setDoOutput(true);
            } catch (IOException e1) {
                e1.printStackTrace();
                return e1.toString();
            }
            try {
                int response_code = conn.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    return (result.toString());
                } else {
                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(KuisKelas9.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected void onPostExecute(String s) {
            listSoal = new ArrayList<>();

            try {
                JSONObject jsonObj = new JSONObject(s);
                soal = jsonObj.getJSONArray(TAG_DAFTAR);
                for (int i = 0; i < soal.length(); i++) {
                    JSONObject jsonObject = soal.getJSONObject(i);
                    QuizData quizData = new QuizData();

                    String id = jsonObject.getString(TAG_ID);
                    String soal = jsonObject.getString(TAG_SOAL);
                    String a = jsonObject.getString(TAG_A);
                    String b = jsonObject.getString(TAG_B);
                    String c = jsonObject.getString(TAG_C);
                    String d = jsonObject.getString(TAG_D);
                    String e = jsonObject.getString(TAG_E);
                    String jwb = jsonObject.getString(TAG_JWB);

                    quizData.setId(id);
                    quizData.setSoal(soal);
                    quizData.setOpsi1(a);
                    quizData.setOpsi2(b);
                    quizData.setOpsi3(c);
                    quizData.setOpsi4(d);
                    quizData.setOpsi5(e);
                    quizData.setAnswer(jwb);
                    listSoal.add(quizData);
                }
            } catch (JSONException e) {
                Toast.makeText(KuisKelas9.this, e.toString(), Toast.LENGTH_LONG).show();
                pb.dismiss();
            }
            super.onPostExecute(s);
            if (pDialog.isShowing())
                pDialog.dismiss();

            jawabanYgDiPilih = new int[listSoal.size()];
            java.util.Arrays.fill(jawabanYgDiPilih, -1);
            jawabanYgBenar = new int[listSoal.size()];
            java.util.Arrays.fill(jawabanYgBenar, -1);
            setUpSoal();
        }
    }

    private void setUpSoal() {
        Collections.shuffle(listSoal);
        tunjukanPertanyaan(0, cekPertanyaan);
    }

    private void tunjukanPertanyaan(int urutan_soal_soal, boolean review) {
        btnSelesai.setEnabled(false);
        if (urutan_soal_soal == 0)
            setUpWaktu();

        try {
            rg.clearCheck();
            QuizData soal = new QuizData();
            soal = listSoal.get(urutan_soal_soal);
            if (jawabanYgBenar[urutan_soal_soal] == -1) {
                jawabanYgBenar[urutan_soal_soal] = Integer.parseInt(soal
                        .getAnswer());
            }

            String soalnya = soal.getSoal();
            txtSoal.setText(soalnya);
            rg.check(-1);
            rb1.setTextColor(Color.WHITE);
            rb2.setTextColor(Color.WHITE);
            rb3.setTextColor(Color.WHITE);
            rb4.setTextColor(Color.WHITE);
            rb5.setTextColor(Color.WHITE);
            rb1.setText(soal.getOpsi1());
            rb2.setText(soal.getOpsi2());
            rb3.setText(soal.getOpsi3());
            rb4.setText(soal.getOpsi4());
            rb5.setText(soal.getOpsi5());

            Log.d("", jawabanYgDiPilih[urutan_soal_soal] + "");
            if (jawabanYgDiPilih[urutan_soal_soal] == 1)
                rg.check(R.id.radio0);
            if (jawabanYgDiPilih[urutan_soal_soal] == 2)
                rg.check(R.id.radio1);
            if (jawabanYgDiPilih[urutan_soal_soal] == 3)
                rg.check(R.id.radio2);
            if (jawabanYgDiPilih[urutan_soal_soal] == 4)
                rg.check(R.id.radio3);
            if (jawabanYgDiPilih[urutan_soal_soal] == 5)
                rg.check(R.id.radio4);

            pasangLabelDanNomorUrut();

            if (urutan_soal_soal == (listSoal.size() - 1)) {
                btnNext.setEnabled(false);
                btnSelesai.setEnabled(true);
            }

            if (urutan_soal_soal == 0)
                btnPrev.setEnabled(false);

            if (urutan_soal_soal > 0)
                btnPrev.setEnabled(true);

            if (urutan_soal_soal < (listSoal.size() - 1))
                btnNext.setEnabled(true);

            if (review) {
                mCountDownTimer.cancel();
                Log.d("priksa", jawabanYgDiPilih[urutan_soal_soal] + ""
                        + jawabanYgBenar[urutan_soal_soal]);
                if (jawabanYgDiPilih[urutan_soal_soal] != jawabanYgBenar[urutan_soal_soal]) {
                    if (jawabanYgDiPilih[urutan_soal_soal] == 1)
                        rb1.setTextColor(Color.RED);
                    if (jawabanYgDiPilih[urutan_soal_soal] == 2)
                        rb2.setTextColor(Color.RED);
                    if (jawabanYgDiPilih[urutan_soal_soal] == 3)
                        rb3.setTextColor(Color.RED);
                    if (jawabanYgDiPilih[urutan_soal_soal] == 4)
                        rb4.setTextColor(Color.RED);
                    if (jawabanYgDiPilih[urutan_soal_soal] == 5)
                        rb5.setTextColor(Color.RED);
                }

                if (jawabanYgBenar[urutan_soal_soal] == 1) {
                    rb1.setTextColor(Color.GREEN);
                } else if (jawabanYgBenar[urutan_soal_soal] == 2) {
                    rb2.setTextColor(Color.GREEN);
                } else if (jawabanYgBenar[urutan_soal_soal] == 3) {
                    rb3.setTextColor(Color.GREEN);
                } else if (jawabanYgBenar[urutan_soal_soal] == 4) {
                    rb4.setTextColor(Color.GREEN);
                } else if (jawabanYgBenar[urutan_soal_soal] == 5) {
                    rb5.setTextColor(Color.GREEN);
                }
            }
        } catch (Exception e) {
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }

    private View.OnClickListener klikSelesai = new View.OnClickListener() {
        public void onClick(View v) {
            aturJawaban_nya();
            // hitung berapa yg benar
            int jumlahJawabanYgBenar = 0;
            for (int i = 0; i < jawabanYgBenar.length; i++) {
                if ((jawabanYgBenar[i] != -1)
                        && (jawabanYgBenar[i] == jawabanYgDiPilih[i]))
                    jumlahJawabanYgBenar++;
            }
            AlertDialog tampilKotakAlert;
            tampilKotakAlert = new AlertDialog.Builder(KuisKelas9.this)
                    .create();
            tampilKotakAlert.setTitle("Hasil");
            tampilKotakAlert.setIcon(R.drawable.ic_star_on);
            tampilKotakAlert.setMessage("Score " + jumlahJawabanYgBenar * 10);

            tampilKotakAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "Lagi",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            mCountDownTimer.cancel();
                            java.util.Arrays.fill(jawabanYgDiPilih, -1);
                            cekPertanyaan = false;
                            urutanPertanyaan = 0;
                            tunjukanPertanyaan(0, cekPertanyaan);
                        }
                    });

            tampilKotakAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Priksa",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            mCountDownTimer.cancel();
                            cekPertanyaan = true;
                            urutanPertanyaan = 0;
                            tunjukanPertanyaan(0, cekPertanyaan);
                        }
                    });

            tampilKotakAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Keluar",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            mCountDownTimer.cancel();
                            cekPertanyaan = false;
                            finish();
                        }
                    });

            tampilKotakAlert.show();

        }
    };

    private void aturJawaban_nya() {
        if (rb1.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 1;
        if (rb2.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 2;
        if (rb3.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 3;
        if (rb4.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 4;
        if (rb5.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 5;

        Log.d("", Arrays.toString(jawabanYgDiPilih));
        Log.d("", Arrays.toString(jawabanYgBenar));

    }

    private View.OnClickListener klikBerikut = new View.OnClickListener() {
        public void onClick(View v) {
            aturJawaban_nya();
            urutanPertanyaan++;
            if (urutanPertanyaan >= listSoal.size())
                urutanPertanyaan = listSoal.size() - 1;

            tunjukanPertanyaan(urutanPertanyaan, cekPertanyaan);
        }
    };

    private View.OnClickListener klikSebelum = new View.OnClickListener() {
        public void onClick(View v) {
            aturJawaban_nya();
            urutanPertanyaan--;
            if (urutanPertanyaan < 0)
                urutanPertanyaan = 0;

            tunjukanPertanyaan(urutanPertanyaan, cekPertanyaan);
        }
    };

    private void pasangLabelDanNomorUrut() {
        txtNo.setText("Question " + (urutanPertanyaan + 1));
        txtCount.setText("/"+listSoal.size());
    }

    private void setUpWaktu() {
        mCountDownTimer = new CounterClass(240000, 1000);
        mCountDownTimer.start();
    }

    @SuppressLint("DefaultLocale")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            finish();
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            txtWaktu.setText(hms);

        }
    }
}