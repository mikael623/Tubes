package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {

    private EditText email;
    private Button send;
    ProgressDialog mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.et_resetpass);
        send = findViewById(R.id.btn_resetpass);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoading.show();
                String email_user = email.getText().toString().trim();
                forgetPassword(email_user);
            }
        });
    }

    private void forgetPassword(String email_user) {
        mLoading.setMessage("Please Wait..");
        mLoading.show();

    }
}