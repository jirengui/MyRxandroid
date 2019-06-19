package com.example.li.myrxandroid.model.http.http_interface;

import com.example.li.myrxandroid.model.entity.RequestBean;
import com.example.li.myrxandroid.model.entity.UserInfo;
import com.example.li.myrxandroid.model.entity.WeatherBean;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author li
 */
public interface ServiceInter {
    @POST("loginUser")
    Observable<RequestBean> logining(@Query("apikey") String apiKey, @Query("name") String userName, @Query("passwd") String password);

    /**
     * 注册
     * @param apiKey 开发者密钥
     * @param userName 账号
     * @param password 密码
     * @param nikeName 昵称
     * @return 用户信息
     */
    @POST("registerUser")
    Observable<RequestBean> register(@Query("apikey") String apiKey, @Query("name") String userName, @Query("passwd") String password, @Query("nikeName") String nikeName);


    /**
     * 查询天气情况
     * @param city 天气查询城市
     * @return 天气 结果
     */
    @POST("weatherApi")
    Observable<WeatherBean> getWeather(@Query("city") String city);
}
