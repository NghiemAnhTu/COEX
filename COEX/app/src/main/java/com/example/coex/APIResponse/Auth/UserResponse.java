package com.example.coex.APIResponse.Auth;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse{

	@SerializedName("password")
	private String password;

	@SerializedName("phone")
	private String phone;

	@SerializedName("typeUser")
	private boolean typeUser;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	@SerializedName("token")
	private List<String> token;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setTypeUser(boolean typeUser){
		this.typeUser = typeUser;
	}

	public boolean isTypeUser(){
		return typeUser;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setToken(List<String> token){
		this.token = token;
	}

	public List<String> getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"UserResponse{" + 
			"password = '" + password + '\'' + 
			",phone = '" + phone + '\'' + 
			",typeUser = '" + typeUser + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}