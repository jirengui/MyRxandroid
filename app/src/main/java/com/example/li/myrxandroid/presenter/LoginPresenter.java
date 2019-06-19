package com.example.li.myrxandroid.presenter;

import android.content.Context;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.entity.UserInfo;
import com.example.li.myrxandroid.model.impl.UserLoginImp;
import com.example.li.myrxandroid.ui.common.MySequent;
import com.example.li.myrxandroid.ui.view.ILoginView;
import com.google.gson.Gson;

/**
 * @author li
 */

public class LoginPresenter implements IWebServiceCallback {
    private ILoginView loginView;
    private Context context;
    private UserLoginImp userLoginImp;

    public LoginPresenter(ILoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
        this.userLoginImp = UserLoginImp.getInstance();
    }

    public void dologin() {
        if (loginView.getAccount() != null) {
            userLoginImp.login(this, MySequent.MYRXANDROID_LOGIN, loginView.getAccount().get(0), loginView.getAccount().get(1));
        }
    }


    @Override
    public void onSuccess(int sequence, Object resultPack) {
        System.out.println("成功了sequence：" + sequence);
        if (sequence == MySequent.MYRXANDROID_LOGIN) {
            Gson gson = new Gson();
            UserInfo userInfo = gson.fromJson((String) resultPack, UserInfo.class);
            loginView.loginSuccess(userInfo);
        }
    }

    @Override
    public void onFailure(int sequence, int errorCode, Object error) {

    }
}
