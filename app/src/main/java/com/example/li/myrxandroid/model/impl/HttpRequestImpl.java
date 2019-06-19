package com.example.li.myrxandroid.model.impl;

import com.example.li.myrxandroid.MyApplication;
import com.example.li.myrxandroid.model.entity.RegisterBean;
import com.example.li.myrxandroid.model.entity.RequestBean;
import com.example.li.myrxandroid.model.entity.WeatherBean;
import com.example.li.myrxandroid.model.http.RxHelpr;
import com.example.li.myrxandroid.model.http.call_back.UserCallBack;
import com.example.li.myrxandroid.model.http.HttpUtil;
import com.example.li.myrxandroid.model.http.http_interface.ServiceInter;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author li
 */
public class HttpRequestImpl {

    private ServiceInter serviceInter;
    private static HttpRequestImpl httpRequest;

    private HttpRequestImpl() {
    }

    public static HttpRequestImpl getInstant() {
        if (httpRequest == null) {
            httpRequest = new HttpRequestImpl();
        }
        return httpRequest;
    }


    public void sendHttp(String userName, String password, UserCallBack subBack) {
        serviceInter = HttpUtil.getInstance().createService(ServiceInter.class);
        serviceInter.logining(MyApplication.apiKey, userName, password)
                .compose(RxHelpr.observableIO2Main())
                .map(requestBean -> {
                    Gson gson = new Gson();
                    return gson.toJson(requestBean);
                })
                .subscribe(subBack);
    }


    public void sendHttpRegist(RegisterBean registerBean, UserCallBack subBack) {
        serviceInter = HttpUtil.getInstance().createService(ServiceInter.class);
        serviceInter.register(MyApplication.apiKey,registerBean.getName(), registerBean.getPasswd(), registerBean.getNikeName())
                .compose(RxHelpr.observableIO2Main())
                .map(requestBean -> {
                    Gson gson = new Gson();
                    return gson.toJson(requestBean);
                })
                .subscribe(subBack);
    }

    public void sendHttpWeather(String city, UserCallBack subBack){
        HttpUtil httpUtil = new HttpUtil(MyApplication.baseWeatherUrl);
        serviceInter =httpUtil.createService(ServiceInter.class);
        serviceInter.getWeather(city)
                .compose(RxHelpr.observableIO2Main())
                .map(weatherBean -> {
                    Gson gson = new Gson();
                    return gson.toJson(weatherBean);
                })
                .subscribe(subBack);
        httpUtil = null;

    }

}
