package com.jd.imitate2jd.detail.mvp.view;

import com.jd.imitate2jd.base.IView;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;

public interface IDetailView extends IView {
    void detailSuccess(DetailBean detailBean);
    void detailFailure(Throwable throwable);
}
