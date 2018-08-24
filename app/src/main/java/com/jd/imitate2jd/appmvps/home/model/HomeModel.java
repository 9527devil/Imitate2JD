package com.jd.imitate2jd.appmvps.home.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class HomeModel implements IHomeModel {

    /**
     *  轮播图的方法
     * @return
     */
    @Override
    public Observable<BannerBean> bannerModel() {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getBannerUrl();
    }

    /**
     *  pager的图片
     * @return
     */
    @Override
    public Observable<PagerBean> pagerModel() {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getPagerUrl();
    }
}
