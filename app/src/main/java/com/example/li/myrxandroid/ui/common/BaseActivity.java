package com.example.li.myrxandroid.ui.common;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.li.myrxandroid.R;
import com.example.li.myrxandroid.ui.view.IBaseView;

/**
 * @author li
 */
public class BaseActivity extends FragmentActivity implements IBaseView {

    private Dialog dialog_loading;


    @Override
    public void showLoading(int strRec) {
        showLoading(getResources().getString(strRec), true);
    }

    @Override
    public void showLoading(String progressMsg, boolean canCancel) {
        hideLoading();
        if (this.isFinishing()) {
            return;
        }
        dialog_loading = new Dialog(this);
        dialog_loading.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_loading.setCancelable(canCancel);

        View sv = LayoutInflater.from(this).inflate(R.layout.dialog_progress, null, false);
        if (!TextUtils.isEmpty(progressMsg)) {
            ((TextView) sv.findViewById(R.id.txtTips)).setText(progressMsg);
        }

        if ((dialog_loading != null) && (!dialog_loading.isShowing())) {
            dialog_loading.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog_loading.getWindow().setContentView(sv);
            dialog_loading.show();
        }
    }

    @Override
    public void showLoading(int strRec, boolean canCancel) {
        showLoading(getResources().getString(strRec), canCancel);
    }


    @Override
    public void hideLoading() {
        if (this.isFinishing()) {
            return;
        }
        if (dialog_loading != null && dialog_loading.isShowing()) {
            dialog_loading.dismiss();
            dialog_loading = null;
        }
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openActivity(Class<?> pClass) {
        startActivity(new Intent(this, pClass));
    }

    @Override
    public void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        intent.putExtras(pBundle);
        startActivity(intent);
    }


    @Override
    public void openIntentActivity(Class<?> pClass, Intent intent) {
        startActivity(intent);
    }

    @Override
    public void openActivityAndClose(Class<?> pClass) {
        startActivity(new Intent(this, pClass));
        this.finish();
    }

    @Override
    public void openActivityAndClose(Class<?> pClass, Bundle pBundle) {
        openActivity(pClass,pBundle);
        this.finish();
    }
}
