package com.example.neerajinnostore.Utils;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance instance = null;
    public static String BASEURL;
    private APIInterface myApi;


    private RetrofitInstance() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Log.i("BaseURl",BASEURL);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(APIInterface.class);

    }

    public static synchronized RetrofitInstance getInstance() {//login
        if (instance == null) {

            instance = new RetrofitInstance();
        }
        return instance;
    }

    public APIInterface getMyApi() {
        return myApi;
    }

}
