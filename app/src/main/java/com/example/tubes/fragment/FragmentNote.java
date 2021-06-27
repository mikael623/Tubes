package com.example.tubes.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tubes.NewNote;
import com.example.tubes.R;
import com.example.tubes.adapter.NoteAdapter;
import com.example.tubes.data.NoteData;

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
import java.util.List;

public class FragmentNote extends Fragment {
    private RecyclerView rV_note;
    private List<NoteData> list = new ArrayList();
    private NoteAdapter adapter;
    private Button add_note;
    //TODO : Ubah database dengan IP Address kalian
    private static String JSON_URL = "http://192.168.40.183/database/get_data_note.php";
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    public FragmentNote() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        rV_note = view.findViewById(R.id.rv_list_note);
        add_note = view.findViewById(R.id.btn_createNote);
        add_note.setText(Html.fromHtml(getString(R.string.take_note)));
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewNote.class);
                getActivity().startActivity(intent);
            }
        });

        GetData getData = new GetData();
        getData.execute();
        return view;
    }

    public class GetData extends AsyncTask<String, String, String> {
        ProgressDialog pb = new ProgressDialog(getActivity());
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
//            super.onPostExecute(s);
            list = new ArrayList<>();

            try {
//                JSONObject jsonObject = new JSONObject(s);
//                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    NoteData noteData = new NoteData();
                    noteData.setImage(jsonObject1.getString("gambar"));
                    noteData.setKelas(jsonObject1.getString("tipe"));
                    noteData.setJudul(jsonObject1.getString("judul"));
                    noteData.setPosted(jsonObject1.getString("posted"));
                    list.add(noteData);
                    pb.setMessage("Successfully Loaded");
                    pb.dismiss();

                }
                PutDataIntoRecyclerView(list);
            } catch (JSONException e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                pb.dismiss();
            }

        }
    }

    private void PutDataIntoRecyclerView(List<NoteData> list) {
        adapter = new NoteAdapter(getActivity(), list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        rV_note.setLayoutManager(gridLayoutManager);
        rV_note.setAdapter(adapter);
        rV_note.setHasFixedSize(true);
    }
}