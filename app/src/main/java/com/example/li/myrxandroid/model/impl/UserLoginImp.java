package com.example.li.myrxandroid.model.impl;

import com.example.li.myrxandroid.model.IWebServiceCallback;
import com.example.li.myrxandroid.model.http.call_back.UserCallBack;
import com.example.li.myrxandroid.model.http.http_interface.ServiceInter;

/**
 * @author li
 */
public class UserLoginImp {
    private static UserLoginImp userLoginImp;
    ServiceInter serviceInter;

    private UserLoginImp(){}

    public static UserLoginImp getInstance(){
        if (userLoginImp == null){
            userLoginImp = new UserLoginImp();
        }
        return userLoginImp;
    }

    public void login(IWebServiceCallback iWebServiceCallback,int sequence, String userName, String password){
        UserCallBack userCallBack = new UserCallBack(iWebServiceCallback,sequence);
        HttpRequestImpl.getInstant().sendHttp(userName, password, userCallBack);
    }
}
