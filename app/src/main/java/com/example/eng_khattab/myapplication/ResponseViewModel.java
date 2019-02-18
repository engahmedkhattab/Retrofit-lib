package com.example.eng_khattab.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResponseViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Response>> responseList;

    public LiveData<ArrayList<Response>> getResponse() {

        if (responseList == null) {
            responseList = new MutableLiveData<>();
            loadResponse();
        }

        return responseList;
    }

    private void loadResponse() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.BaseURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        Service service = retrofit.create(Service.class);
        Call<ArrayList<Response>> call = service.method();

        call.enqueue(new Callback<ArrayList<Response>>() {
            @Override
            public void onResponse(Call<ArrayList<Response>> call, retrofit2.Response<ArrayList<Response>> response) {

                responseList.setValue(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Response>> call, Throwable t) {

            }
        });
    }

}
