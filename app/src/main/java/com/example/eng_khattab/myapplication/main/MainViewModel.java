package com.example.eng_khattab.myapplication.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.eng_khattab.myapplication.data.Service;
import com.example.eng_khattab.myapplication.data.WebServiceClient;
import com.example.eng_khattab.myapplication.main.pojo.Response;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;


public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Response>> responseList;

    public LiveData<ArrayList<Response>> getResponse() {

        if (responseList == null) {
            responseList = new MutableLiveData<>();
            loadResponse();
        }

        return responseList;
    }

    private void loadResponse() {

        Service service = WebServiceClient.getClient().create(Service.class);

        Call<ArrayList<Response>> call = service.methodRepos();

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