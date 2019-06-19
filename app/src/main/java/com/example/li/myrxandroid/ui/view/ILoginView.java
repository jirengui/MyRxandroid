package com.example.li.myrxandroid.ui.view;

import com.example.li.myrxandroid.model.entity.UserInfo;

import java.util.ArrayList;

public interface ILoginView extends IBaseView {
    /**
     *
     * @param userName 账号
     * @param password 密码
     * @param isAutoLogin 自动登录
     */
    void setAccount(String userName, String password, Boolean isAutoLogin);

    /**
     *
     * @return 账号密码返回，0为账号，1为密码。
     */
    ArrayList<String> getAccount();

    /**
     * 登录成功调用
     */
    void loginSuccess(UserInfo userInfo);
}
