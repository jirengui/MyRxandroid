package com.example.li.myrxandroid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.li.myrxandroid.R;
import com.example.li.myrxandroid.model.entity.UserInfo;
import com.example.li.myrxandroid.presenter.LoginPresenter;
import com.example.li.myrxandroid.ui.common.BaseActivity;
import com.example.li.myrxandroid.ui.common.MySequent;
import com.example.li.myrxandroid.ui.view.ILoginView;

import java.util.ArrayList;

/**
 * @author li
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        loginPresenter = new LoginPresenter(this, this);
        findViewById(R.id.login_login).setOnClickListener(this);
        findViewById(R.id.login_register).setOnClickListener(this);
    }

    private EditText getLoginUserName() {
        return (EditText) findViewById(R.id.login_userName);
    }

    private EditText getLoginPassword() {
        return (EditText) findViewById(R.id.login_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login:
                doLogin();
                break;
            case R.id.login_register:
                doRegister();
                break;
            default:
                break;
        }
    }

    //注册
    private void doRegister() {
        openActivity(RegisterActivity.class);
    }

    //登录
    private void doLogin() {
        showLoading("加载中···", false);
        loginPresenter.dologin();
    }

    @Override
    public void setAccount(String userName, String password, Boolean isAutoLogin) {
        getLoginUserName().setText(userName);
        getLoginPassword().setText(password);
        if (isAutoLogin){
            doLogin();
        }
    }

    @Override
    public ArrayList<String> getAccount() {
        String userName = getLoginUserName().getText().toString();
        String password = getLoginPassword().getText().toString();
        if (!userName.isEmpty() && !password.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(getLoginUserName().getText().toString());
            list.add(getLoginPassword().getText().toString());
            return list;
        }else {
            hideLoading();
            showMsg("账号密码不能为空！");
            return null;
        }
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {
        hideLoading();
        if (userInfo.getCode() == MySequent.MYRXANDROID_CODE_SUCCESS) {
            showMsg("登录成功哦：" + userInfo.getResult().getName());
            openActivityAndClose(MainActivity.class);
        }else {
            showMsg(userInfo.getMessage());
        }
    }
}
