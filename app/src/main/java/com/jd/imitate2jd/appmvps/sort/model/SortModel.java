package com.jd.imitate2jd.appmvps.sort.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class SortModel implements ISortModel {

    @Override
    public Observable<MenuBean> modelMenu() {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getMenuUrl();
    }

    @Override
    public Observable<InfoBean> modelInfo(String cid) {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getInfoUrl(cid);
    }
}
