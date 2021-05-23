package com.example.roomtest.core;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lenovo
 * 创建时间： 2021/5/22 15:02
 * 类描述：
 */
public class Api {

    private static ApiService apiService;

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().
            readTimeout(60, TimeUnit.SECONDS).build();

    private Api() {
    }

    public static ApiService getApiService() {
        String httpAddress = "https://wanandroid.com/";
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(httpAddress)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
