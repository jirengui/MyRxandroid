package com.example.li.myrxandroid.presenter;

import android.content.Context;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.entity.WeatherBean;
import com.example.li.myrxandroid.model.impl.MainImp;
import com.example.li.myrxandroid.model.impl.UserLoginImp;
import com.example.li.myrxandroid.ui.common.MySequent;
import com.example.li.myrxandroid.ui.view.ILoginView;
import com.example.li.myrxandroid.ui.view.IMainView;
import com.google.gson.Gson;

public class MainPresenter implements IWebServiceCallback {

    private IMainView iMainView;
    private Context context;
    private MainImp mainImp;

    public MainPresenter(IMainView iMainView, Context context) {
        this.iMainView = iMainView;
        this.context = context;
        this.mainImp = MainImp.getInstance();
    }

    public void getWeather(){
        mainImp.getWeather(this, MySequent.MYRXANDROID_WEATHER, "南京");
    }


    @Override
    public void onSuccess(int sequence, Object resultPack) {
        System.out.println("温度返回：" + resultPack);
        Gson gson = new Gson();
        WeatherBean weatherBean = gson.fromJson((String) resultPack, WeatherBean.class);
        iMainView.setText(weatherBean.getData().toString());
    }

    @Override
    public void onFailure(int sequence, int errorCode, Object error) {

    }
}
