package com.jd.imitate2jd.utils;

import com.jd.imitate2jd.api.ApiProvide;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager mRetrofirManager;
    private Retrofit mRetrofit;

    public static RetrofitManager getRetrofitManager() {
        if (mRetrofirManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofirManager == null) {
                     mRetrofirManager = new RetrofitManager(ApiProvide.BASEURL);
                    return mRetrofirManager;
                }
            }
        }
        return mRetrofirManager;
    }

    public RetrofitManager(String baseUrl){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 动态代理
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T create (Class<T> clazz){
        return mRetrofit.create(clazz);
    }
}
