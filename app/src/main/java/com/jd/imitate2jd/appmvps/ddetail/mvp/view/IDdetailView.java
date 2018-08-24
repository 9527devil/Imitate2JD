package com.jd.imitate2jd.appmvps.ddetail.mvp.view;

import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;
import com.jd.imitate2jd.base.IView;

public interface IDdetailView extends IView {
    void ddetailSuccess(DdetailBean ddetailBean);
    void ddetailFailure(Throwable throwable);
}
