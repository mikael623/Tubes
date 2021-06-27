package com.example.tubes.api;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://192.168.43.246/apiSobatPintar/public/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiServices getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiServices.class);
    }
}
