package com.example.eng_khattab.myapplication.details;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.eng_khattab.myapplication.data.Service;
import com.example.eng_khattab.myapplication.data.WebServiceClient;
import com.example.eng_khattab.myapplication.details.pojo.Commit;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;

public class DetailsViewModel extends ViewModel {

    private String name;
    private MutableLiveData<ArrayList<Commit>> commitList;

    public LiveData<ArrayList<Commit>> getCommit() {

        if (commitList == null) {
            commitList = new MutableLiveData<>();
            loadCommit();
        }

        return commitList;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    private void loadCommit() {

        Service service = WebServiceClient.getClient().create(Service.class);

        Call<ArrayList<Commit>> call = service.methodCommit(getName());

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