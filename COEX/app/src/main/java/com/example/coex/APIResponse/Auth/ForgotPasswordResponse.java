package com.example.coex.APIResponse.Auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponse{

	@SerializedName("message")
	@Expose
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ForgotPasswordResponse{" + 
			"message = '" + message + '\'' +
			"}";
		}
}