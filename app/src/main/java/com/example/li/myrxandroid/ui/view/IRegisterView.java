package com.example.li.myrxandroid.ui.view;

import com.example.li.myrxandroid.model.entity.RegisterBean;
import com.example.li.myrxandroid.model.entity.UserInfo;

import java.util.ArrayList;

/**
 * @author li
 */
public interface IRegisterView extends IBaseView {


    /**
     *获取用户输入信息
     * @return 注册信息返回。
     */
    RegisterBean getAccount();

    /**
     * 注册成功调用
     */
    void registerSuccess();

    void registerError();
}
