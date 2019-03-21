package com.example.movs_project.Model;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    public static  String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/9.6.1/data/en_US/";
    public static  String BASE_URL2 ="https://euw1.api.riotgames.com/";
    private static final String KEY = "RGAPI-9ee11c6d-ed05-428d-8dd3-de1a58e5ec45";


    public static Retrofit getRetrofitInstanceLOL() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder().addHeader("X-Riot-Token", KEY).build();
                            return chain.proceed(request);
                        }
                    }).build();


            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }

}
