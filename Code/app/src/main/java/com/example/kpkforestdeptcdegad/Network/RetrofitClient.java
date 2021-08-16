package com.example.kpkforestdeptcdegad.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //database user name = forestdept
    // password = K8[UlN0XlVDhxJ(6
//000web host free hosting and domain

   /* public static String IMAGE_BASE_URL = "https://omnivorous-glide.000webhostapp.com/images/";
    private static String BASE_URL = "https://omnivorous-glide.000webhostapp.com/";*/

    public static String IMAGE_BASE_URL = "http://192.168.43.174:82/forestApi/images/";
    private static String BASE_URL = "http://192.168.43.174:82/forestApi/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    public RetrofitClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build())
                .build();


    }

    public static synchronized RetrofitClient getInstance() {

        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Webservices getApi() {
        return retrofit.create(Webservices.class);
    }

}
