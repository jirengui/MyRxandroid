package com.example.li.myrxandroid.ui.view;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author li
 */
public interface IBaseView {
    void showLoading(int strRec);

    void showLoading(String progressMsg, boolean canCancel);

    void showLoading(int strRec, boolean canCancel);

    void hideLoading();

    void showMsg(String Msg);

    void openActivity(Class<?> pClass);

    void openActivity(Class<?> pClass, Bundle pBundle);

    void openIntentActivity(Class<?> pClass, Intent intent);

    void openActivityAndClose(Class<?> pClass);

    void openActivityAndClose(Class<?> pClass, Bundle pBundle);
}
