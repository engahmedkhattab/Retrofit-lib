package com.example.eng_khattab.myapplication.details;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.eng_khattab.myapplication.data.Service;
import com.google.gson.Gson;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Commit>> commitList;

    public LiveData<ArrayList<Commit>> getCommit() {

        if (commitList == null) {
            commitList = new MutableLiveData<>();
            loadCommit();
        }

        return commitList;
    }

    private void loadCommit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.BaseURLCommit)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        Service service = retrofit.create(Service.class);
        Call<ArrayList<Commit>> call = service.methodCommit();

        call.enqueue(new Callback<ArrayList<Commit>>() {
            @Override
            public void onResponse(Call<ArrayList<Commit>> call, retrofit2.Response<ArrayList<Commit>> commit) {

                commitList.setValue(commit.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Commit>> call, Throwable t) {

            }
        });
    }

}