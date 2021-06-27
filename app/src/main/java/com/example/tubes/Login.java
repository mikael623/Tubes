package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
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

public class Login extends AppCompatActivity {

    private TextView forget, regist;
    private EditText email, pass;
    private Button login;
    private ProgressDialog mLoading;
    private BaseApiServices mApiService;
    private Context mContext;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forget = findViewById(R.id.forgetpass);
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        regist = findViewById(R.id.register);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, ForgetPassword.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialLogin();
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    private void initialLogin() {
        String email_user = email.getText().toString();
        final String password_user = pass.getText().toString();
        if (email_user.isEmpty()) {
            email.setError("Masukan Email");
            email.setFocusable(true);
        } else if (password_user.isEmpty()) {
            pass.setError("Masukan Password");
            pass.setFocusable(true);
        } else if (!email_user.matches(emailPattern)) {
            email.setError("Masukan Email yang Valid");
            email.setFocusable(true);
        } else {
            login(email_user, password_user);
        }
    }

    private void login(String email_user, String password_user) {
        mApiService.login(email_user, password_user)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("success").equals("true")) {
                                    Toast.makeText(mContext, "Berhasil login", Toast.LENGTH_LONG).show();
                                } else {
                                    String message = jsonRESULTS.getString("message");
                                    Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                    }
                });
    }
}