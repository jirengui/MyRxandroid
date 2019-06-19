package com.example.li.myrxandroid.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.li.myrxandroid.R;
import com.example.li.myrxandroid.presenter.MainPresenter;
import com.example.li.myrxandroid.ui.common.BaseActivity;
import com.example.li.myrxandroid.ui.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView, View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_test);
        findViewById(R.id.main_bt_photo).setOnClickListener(this);
        MainPresenter mainPresenter = new MainPresenter(this, this);
        mainPresenter.getWeather();
    }


    @Override
    public void setText(String s) {
        textView.setText(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bt_photo:
                showMsg("啥都没有。。。");
                break;
            default:
                break;
        }
    }
}
