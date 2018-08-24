package com.jd.imitate2jd.appmvps.home.model;

import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;

import io.reactivex.Observable;

public interface IHomeModel {
    Observable<BannerBean> bannerModel();
    Observable<PagerBean> pagerModel();
}
