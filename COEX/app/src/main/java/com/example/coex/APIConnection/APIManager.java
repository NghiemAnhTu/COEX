package com.example.coex.APIConnection;

public class APIManager {
    public static final String BASE_URL = "http://192.168.1.2:3000/";
    public static APIService getAPIService(){
        return APIClient.getClient(BASE_URL).create(APIService.class);
    }
}
