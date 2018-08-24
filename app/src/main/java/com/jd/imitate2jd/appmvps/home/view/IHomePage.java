package com.jd.imitate2jd.appmvps.home.view;

import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.base.IView;

public interface IHomePage extends IView {
    void homeSuccess(BannerBean bannerBean);
    void homeFailure(Throwable throwable);
    void pagerSuccess(PagerBean pagerBean);
    void pagerFailure(Throwable throwable);
}
