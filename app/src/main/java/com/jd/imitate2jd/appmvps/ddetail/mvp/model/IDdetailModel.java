package com.jd.imitate2jd.appmvps.ddetail.mvp.model;

import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;

import io.reactivex.Observable;

public interface IDdetailModel {
    public Observable<DdetailBean> ddetailModel(String pid);
}
