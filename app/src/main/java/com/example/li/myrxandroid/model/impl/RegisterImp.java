package com.example.li.myrxandroid.model.impl;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.entity.RegisterBean;
import com.example.li.myrxandroid.model.http.call_back.UserCallBack;

/**
 * @author li
 */
public class RegisterImp {
    private static RegisterImp registerImp;

    private RegisterImp(){}
    public static synchronized RegisterImp getInstance(){
        if (registerImp == null){
            registerImp = new RegisterImp();
        }
        return registerImp;
    }
    public void register(IWebServiceCallback iWebServiceCallback, int sequence, RegisterBean registerBean){
        UserCallBack userCallBack = new UserCallBack(iWebServiceCallback,sequence);
        HttpRequestImpl.getInstant().sendHttpRegist(registerBean, userCallBack);
    }
}
