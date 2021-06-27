package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tubes.adapter.MateriAdapter;
import com.example.tubes.data.MateriData;

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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;

public class Materi extends AppCompatActivity {
    private RecyclerView rV_materi;
    private List<MateriData> listmateri;
    private MateriAdapter adaptermateri;
    private EditText searchView;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;


    //JSON URL =    https://run.mocky.io/v3/9169d365-ef98-45cf-a397-f3ca4b187939
    //or            http://192.168.40.183/database/get_data.php
    //or            http://192.168.40.183/wpu-rest-server/api/materi
    //TODO : Ubah database dengan IP Address kalian
    private static String JSON_URL = "http://192.168.43.246/database/get_data.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        rV_materi = findViewById(R.id.rv_list_materi);
        listmateri = new ArrayList<>();
        searchView = (EditText) findViewById(R.id.search);

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                FilterList(s.toString());
            }
        });


        GetData getData = new GetData();
        getData.execute();
    }

    private void FilterList(String text) {
        ArrayList<MateriData> filterList = new ArrayList<>();
        for (MateriData data:listmateri) {
            if (data.getJudul().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(data);
            }
        }
        adaptermateri.filtered(filterList);
    }

    public class GetData extends AsyncTask<String, String, String> {
        ProgressDialog pb = new ProgressDialog(Materi.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setMessage("Loading...");
            pb.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL(JSON_URL);
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
        protected void onPostExecute(String s) {
            listmateri = new ArrayList<>();
            try {
//                JSONObject jsonObject = new JSONObject(s);
//                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    MateriData materiData = new MateriData();
                    materiData.setJudul(jsonObject1.getString("judul_materi"));
                    materiData.setSubjudul(jsonObject1.getString("submateri"));
                    materiData.setDeskripsi(jsonObject1.getString("isi_materi"));
                    materiData.setGambar(jsonObject1.getString("gambar"));
                    listmateri.add(materiData);
                    pb.dismiss();

                }
            } catch (JSONException e) {
                Toast.makeText(Materi.this, e.toString(), Toast.LENGTH_LONG).show();
            }
            PutDataIntoRecyclerView (listmateri);
        }
    }

    private void PutDataIntoRecyclerView(List<MateriData> listmateri) {
        adaptermateri = new MateriAdapter(listmateri, this);
        GridLayoutManager lm = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false);
        rV_materi.setLayoutManager(lm);
        rV_materi.setHasFixedSize(true);
        rV_materi.setAdapter(adaptermateri);
    }

}