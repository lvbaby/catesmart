package com.fancyedu.catesmart.utils;

import android.util.Log;


import com.fancyedu.catesmart.common.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sww on 2016/9/27.
 */
public class OkHttpUtil {


    /**
     * 自定义header
     *
     * @return
     */
    public static Retrofit withCustomHeader() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    /**
     * 统一header
     * getWithHeaders
     *
     * @return
     */
    public static Retrofit withHeaders() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


    /**
     * 请求中加上统一header
     */
    public static class LoggingInterceptor implements Interceptor {


        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
            long t1 = System.nanoTime();

            Request request = chain.request()
                    .newBuilder()
                    .addHeader("header", "value")
                    .build();

            okhttp3.Response response = chain.proceed(request);
            Log.i("body", response.toString());
            long t2 = System.nanoTime();

            return response;
        }
    }

}
