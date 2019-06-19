package com.example.li.myrxandroid.model.http.call_back;

import com.example.li.myrxandroid.model.IWebServiceCallback;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author li
 */
public class UserCallBack implements Observer<String> {

    private IWebServiceCallback webServiceCallback;
    private int sequent;
    public UserCallBack(IWebServiceCallback webServiceCallback, int sequent){
        this.webServiceCallback = webServiceCallback;
        this.sequent = sequent;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {
        webServiceCallback.onSuccess(sequent, s);

    }


    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
