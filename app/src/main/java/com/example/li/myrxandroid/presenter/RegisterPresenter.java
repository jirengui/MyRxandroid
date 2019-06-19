package com.example.li.myrxandroid.presenter;

import android.content.Context;
import android.util.Log;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.entity.UserInfo;
import com.example.li.myrxandroid.model.impl.RegisterImp;
import com.example.li.myrxandroid.ui.common.MySequent;
import com.example.li.myrxandroid.ui.view.IRegisterView;
import com.google.gson.Gson;

import static android.content.ContentValues.TAG;

public class RegisterPresenter implements IWebServiceCallback {

    private Context context;
    private IRegisterView iRegisterView;

    public RegisterPresenter(Context context, IRegisterView iRegisterView){
        this.context = context;
        this.iRegisterView = iRegisterView;
    }

    public void doRegister(){
        if (iRegisterView.getAccount() != null) {
            RegisterImp.getInstance().register(this, MySequent.MYRXANDROID_REGISTER, iRegisterView.getAccount());
        }
    }

    @Override
    public void onSuccess(int sequence, Object resultPack) {
        Log.i(TAG, "onSuccess: " + sequence);
        if (sequence == MySequent.MYRXANDROID_REGISTER){
            Gson gson = new Gson();
            UserInfo userInfo = gson.fromJson((String) resultPack, UserInfo.class);
            if (userInfo.getCode() == MySequent.MYRXANDROID_CODE_SUCCESS){
                iRegisterView.registerSuccess();
            }else {
                iRegisterView.registerError();
            }
        }
    }

    @Override
    public void onFailure(int sequence, int errorCode, Object error) {

    }
}
