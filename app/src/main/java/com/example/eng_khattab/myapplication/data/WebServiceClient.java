package com.example.eng_khattab.myapplication.data;

import com.example.eng_khattab.myapplication.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {

    public static final String API_BASE_URL = "https://api.github.com/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        // add OKHttp log debug
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }
        // rise connection timeout
        clientBuilder.connectTimeout(1, TimeUnit.MINUTES) // connect timeout
                .readTimeout(30, TimeUnit.SECONDS)    // socket timeout
                //.writeTimeout(20, TimeUnit.SECONDS) // write timeout
                .build();

        Gson gson =
                new GsonBuilder()
                        .create();

        if (retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(clientBuilder.build())
                    .build();
        }

        return retrofit;
    }

}
