package com.jd.imitate2jd.detail.mvp.model;

import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;

import io.reactivex.Observable;

public interface IDetailModel {
    Observable<DetailBean> detailModel(String pscid);
}
