package com.jd.imitate2jd.detail.mvp.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class DetailModel implements IDetailModel {
    @Override
    public Observable<DetailBean> detailModel(String pscid) {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getDetail(pscid);
    }
}
