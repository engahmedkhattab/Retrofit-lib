package com.example.eng_khattab.myapplication;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    String BaseURL = "https://api.github.com/users/";

    @GET("3bdoelnaggar/repos")
    Call<ArrayList<Response>>method();

}