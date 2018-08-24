package com.jd.imitate2jd.appmvps.reg.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class RegModel {
    public Observable<RegBean> modelReg(String mobile,String password){
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getReg(mobile,password);
    }
}
