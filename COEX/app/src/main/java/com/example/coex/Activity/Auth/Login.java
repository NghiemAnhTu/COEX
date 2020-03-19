package com.example.coex.Activity.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coex.APIConnection.APIManager;
import com.example.coex.APIResponse.Auth.LoginResponse;
import com.example.coex.MainActivity;
import com.example.coex.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView txtLogin;
    TextView txtForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // anh xa view
        initView();
        //  click button login
        onLogin();
        // click forgot password
        onForgotPassword();
        // click register
        onRegister();
    }

    // init view
    public void initView() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtLogin = findViewById(R.id.txtLogin);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
    }

    // on click login button
    private void onLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("email", email);
                    jsonObject.put("password", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                APIManager.getAPIService().getTokenLogin(jsonObject.toString()).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                        Log.d("Code", response.code() +"");
                        if (response.code() == 200) {
                            String token = response.body().getToken();
                            Toast.makeText(getApplication(), token, Toast.LENGTH_SHORT).show();
                            // vao phien lam viec
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplication(), "Invalid email or password.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        // debug
                    }
                });
            }
        });
    }

    // on click txt forgot password
    private void onForgotPassword() {
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    // on click txt register
    private void onRegister() {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Register.class);
                startActivity(intent);
            }
        });
    }
}

