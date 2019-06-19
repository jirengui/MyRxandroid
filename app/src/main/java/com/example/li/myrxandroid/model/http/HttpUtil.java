package com.example.li.myrxandroid.model.http;

import com.example.li.myrxandroid.MyApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author li
 */
public class HttpUtil {
    private static  HttpUtil httpUtil;
    private Retrofit retrofit;

    public static synchronized HttpUtil getInstance(){
        if (httpUtil == null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public  HttpUtil(String baseUrl){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //连接 超时时间
        builder.connectTimeout(20, TimeUnit.SECONDS);
        //写操作 超时时间
        builder.writeTimeout(20,TimeUnit.SECONDS);
        //读操作 超时时间
        builder.readTimeout(20,TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//设定日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //添加拦截器
        builder.addInterceptor(httpLoggingInterceptor);

//创建并指定自定义的OkHttpClient
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }



    private  HttpUtil(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //连接 超时时间
        builder.connectTimeout(20, TimeUnit.SECONDS);
        //写操作 超时时间
        builder.writeTimeout(20,TimeUnit.SECONDS);
        //读操作 超时时间
        builder.readTimeout(20,TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//设定日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //添加拦截器
        builder.addInterceptor(httpLoggingInterceptor);

//创建并指定自定义的OkHttpClient
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyApplication.baseUrl)
                .build();
    }

    public  <V> V createService(Class<V> serviceClass){
        return retrofit.create(serviceClass);
    }

}
