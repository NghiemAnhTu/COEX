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
import com.example.coex.APIResponse.Auth.RegisterResponse;
import com.example.coex.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText edtEmail, edtPassword, edtConfirmPassword;
    Button btnRegister;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // anh xa view
        initView();
        // click button register
        onRegister();
        // click txt login
        onLogin();
    }

    // anh xa view
    public void initView() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtRegister);
    }

    // click button register
    public void onRegister() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirmPassword = edtConfirmPassword.getText().toString().trim();
                boolean typeUser = true;
                final JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("email", email);
                    jsonObject.put("password", password);
                    jsonObject.put("typeUser", typeUser);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (password.equals(confirmPassword)) {
                    APIManager.getAPIService().createrCoex(jsonObject.toString()).enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                            if (response.code() == 200) {
                                String message = response.body().getMessage();
                                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
                                // thanh cong
                            } else if (response.code() == 406) {
                                Toast.makeText(getApplication(), "Email is used!", Toast.LENGTH_SHORT).show();
                            } else if (response.code() == 422) {
                                Toast.makeText(getApplication(), "Invalid email and password must be minimum 6 characters!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplication(), "Password is not correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // on click txt login
    public void onLogin(){
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Login.class);
                startActivity(intent);
            }
        });
    }
}
