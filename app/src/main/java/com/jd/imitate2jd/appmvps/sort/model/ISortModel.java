package com.jd.imitate2jd.appmvps.sort.model;

import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;

import io.reactivex.Observable;

public interface ISortModel {
    Observable<MenuBean> modelMenu();
    Observable<InfoBean> modelInfo(String cid);
}
