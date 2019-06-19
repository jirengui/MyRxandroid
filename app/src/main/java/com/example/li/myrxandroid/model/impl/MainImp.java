package com.example.li.myrxandroid.model.impl;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.entity.RegisterBean;
import com.example.li.myrxandroid.model.http.call_back.UserCallBack;

import java.util.Map;

public class MainImp {
    private static MainImp mainImp;

    private MainImp(){}

    public static synchronized MainImp getInstance(){
        if (mainImp == null){
            mainImp = new MainImp();
        }
        return mainImp;
    }

    public  void getWeather(IWebServiceCallback iWebServiceCallback, int sequence, String city){
        UserCallBack userCallBack = new UserCallBack(iWebServiceCallback,sequence);
        HttpRequestImpl.getInstant().sendHttpWeather(city, userCallBack);
    }
}
