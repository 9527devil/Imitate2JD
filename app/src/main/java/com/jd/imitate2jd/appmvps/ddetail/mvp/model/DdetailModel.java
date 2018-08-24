package com.jd.imitate2jd.appmvps.ddetail.mvp.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class DdetailModel implements IDdetailModel {
    @Override
    public Observable<DdetailBean> ddetailModel(String pid) {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getDdetail(pid);
    }
}
