package com.example.coex.APIConnection;



import com.example.coex.APIResponse.Auth.ForgotPasswordResponse;
import com.example.coex.APIResponse.Auth.LoginResponse;
import com.example.coex.APIResponse.Auth.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    // call api login
    @Headers("Content-Type:application/json")
    @POST("users/login")
    Call<LoginResponse> getTokenLogin(
            @Body String body
    );

    // call api forgot password
    @Headers("Content-Type:application/json")
    @POST("users/forgotpassword")
    Call<ForgotPasswordResponse> resetPassword(
            @Body String body
    );

    // call api user
    @Headers("Content-Type:application/json")
    @POST("users")
    Call<RegisterResponse> createrCoex(
            @Body String body
    );

}
