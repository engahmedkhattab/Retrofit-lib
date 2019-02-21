package com.example.eng_khattab.myapplication.data;

import com.example.eng_khattab.myapplication.details.pojo.Commit;
import com.example.eng_khattab.myapplication.main.pojo.Response;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("users/3bdoelnaggar/repos")
    Call<ArrayList<Response>> methodRepos();


    @GET("repos/3bdoelnaggar/{user_id}/commits")
    Call<ArrayList<Commit>>methodCommit(@Path(value = "user_id", encoded = true) String userId);

}