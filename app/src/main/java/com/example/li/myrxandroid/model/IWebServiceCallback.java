package com.example.li.myrxandroid.model;

/**
 * @author li
 */
public interface IWebServiceCallback<String> {
    /**
     * @param sequence   请求序号
     * @param resultPack 返回信息
     */
    void onSuccess(int sequence, String resultPack);

    /**
     * @param sequence  请求序号
     * @param errorCode 错误标志
     * @param error     错误信息
     */
    void onFailure(int sequence, int errorCode, String error);
}
