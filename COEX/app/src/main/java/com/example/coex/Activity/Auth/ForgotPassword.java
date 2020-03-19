package com.example.coex.Activity.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.coex.APIConnection.APIManager;
import com.example.coex.APIResponse.Auth.ForgotPasswordResponse;
import com.example.coex.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    EditText edtEmail;
    Button btnSendEmail;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        // anh xa view
        initView();
        // click send email
        onSendEmail();
        // back
        onBackLogin();

    }

    // init View
    public void initView() {
        edtEmail = findViewById(R.id.edtEmail);
        btnSendEmail = findViewById(R.id.btnForgotPassword);
        imgBack = findViewById(R.id.btnBack);
    }

    // click send email
    private void onSendEmail() {
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                if (email.length() == 0) {
                    Toast.makeText(getApplication(), "Email is not null", Toast.LENGTH_SHORT).show();
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("email", email);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    APIManager.getAPIService().resetPassword(jsonObject.toString()).enqueue(new Callback<ForgotPasswordResponse>() {
                        @Override
                        public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
//                            Log.d("Code", response.code() + "");
                            if (response.code() == 200) {
                                String message = response.body().getMessage();
                                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
                                // xu li tiep theo
                            } else {
                                Toast.makeText(getApplication(), "Not found your account", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {
                            // debug
                        }
                    });
                }
            }
        });
    }

    // back
    // back
    private void onBackLogin(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
