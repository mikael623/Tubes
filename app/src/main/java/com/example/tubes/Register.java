package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tubes.api.BaseApiServices;
import com.example.tubes.api.UtilsApi;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private EditText nama, email, pass;
    private Button regist;
    private TextView tv_halLogin;
    BaseApiServices mApiService;
    private ProgressDialog mLoading;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String emailUser,namaUser,passwordUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        mLoading = new ProgressDialog(this);
//        mLoading.setMessage("Please Wait..");
        nama = findViewById(R.id.et_fullname);
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        regist = findViewById(R.id.btn_register);
        mApiService = UtilsApi.getAPIService();

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialRegist();
            }
        });

        tv_halLogin = findViewById(R.id.tv_halamanlogin);
        tv_halLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initialRegist(){

        namaUser = nama.getText().toString();
        emailUser = email.getText().toString();
        passwordUser = pass.getText().toString();

        if (emailUser.isEmpty()){
            email.setError("Masukan Email Terlebih Dahulu");
            email.setFocusable(true);
        }else if (!emailUser.matches(emailPattern)){
            email.setError("Masukan Format Email yang Benar");
            email.setFocusable(true);
        }else if (namaUser.isEmpty()) {
            nama.setError("Masukan Nama Terlebih Dahulu");
            nama.setFocusable(true);
        }else if (passwordUser.isEmpty()) {
            pass.setError("Masukan Password Anda");
            pass.setFocusable(true);
        } else if (passwordUser.length() < 8) {
            pass.setError("Masukan Password minimal 8");
            pass.setFocusable(true);
        }
        else{
            registrasiUser();
        }
    }

    private void registrasiUser() {
        mApiService.addRegisterData(namaUser,emailUser,passwordUser).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            mLoading.show();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("message").equals("CREATED")){
                                    Toast.makeText(Register.this, "Berhasil mendaftar!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(Register.this,Login.class));
                                    finish();
                                } else {
                                    String message = jsonRESULTS.getString("message");
                                    Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GAGAL");
//                            mLoading.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                }
        );

    }
}