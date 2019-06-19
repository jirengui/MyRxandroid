package com.example.li.myrxandroid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.li.myrxandroid.R;
import com.example.li.myrxandroid.model.entity.RegisterBean;
import com.example.li.myrxandroid.presenter.RegisterPresenter;
import com.example.li.myrxandroid.ui.common.BaseActivity;
import com.example.li.myrxandroid.ui.view.IRegisterView;

/**
 * @author li
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener, IRegisterView {

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerPresenter = new RegisterPresenter(this, this);
        findViewById(R.id.register_register).setOnClickListener(this);
    }

    private EditText getRegisterUserName() {
        return (EditText) findViewById(R.id.register_user_name);
    }

    private EditText getRegisterPassword() {
        return (EditText) findViewById(R.id.register_password);
    }

    private EditText getRegisterNikeName() {
        return (EditText) findViewById(R.id.register_nike_name);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_register:
                //TODO implement
                doRegister();
                break;
            default:
                break;
        }
    }

    private void doRegister() {
        showLoading("正在注册···" , false);
        registerPresenter.doRegister();
    }


    @Override
    public RegisterBean getAccount() {
        if (isNull()){
            return null;
        }else {
            return new RegisterBean(getRegisterUserName().getText().toString(), getRegisterPassword().getText().toString(), getRegisterNikeName().getText().toString());
        }
    }

    @Override
    public void registerSuccess() {
        hideLoading();
        showMsg("注册成功！");
        finish();
    }

    @Override
    public void registerError() {
        hideLoading();
        showMsg("注册失败，请重试。");
    }

    public boolean isNull() {
        if (getRegisterUserName().getText().toString().isEmpty()) {
            showMsg("用户名不能为空！");
            return true;
        } else if (getRegisterPassword().getText().toString().isEmpty()) {
            showMsg("密码不能为空！");
            return true;
        } else if (getRegisterNikeName().getText().toString().isEmpty()) {
            showMsg("昵称不能为空！");
            return true;
        } else {
            return false;
        }
    }
}
