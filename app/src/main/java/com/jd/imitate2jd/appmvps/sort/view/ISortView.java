package com.jd.imitate2jd.appmvps.sort.view;

import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;
import com.jd.imitate2jd.base.IView;

public interface ISortView extends IView {
    void getMenuSuccess(MenuBean menuBean);
    void getMenuFailure(Throwable throwable);
    void getInfoSuccess(InfoBean infoBean);
    void getInfoFailure(Throwable throwable);
}
