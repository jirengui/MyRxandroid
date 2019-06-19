package com.example.li.myrxandroid.model.http;

import android.content.Context;

import com.example.li.myrxandroid.model.entity.RequestBean;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxHelpr {

    public static <T> ObservableTransformer<T, T> observableIO2Main() {
        return upstream -> {
            Observable<T> observable = upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
            return  observable;
        };
    }



}
