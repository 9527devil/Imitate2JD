package com.jd.imitate2jd.appmvps.login.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.appmvps.login.model.bean.LoginBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class LoginModel {
    public Observable<LoginBean> modelLogin(String mobile, String password){
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getLogin(mobile,password);
    }
}
