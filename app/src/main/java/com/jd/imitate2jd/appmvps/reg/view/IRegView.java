package com.jd.imitate2jd.appmvps.reg.view;

import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.base.IView;

public interface IRegView extends IView {
    void regSuccess(RegBean bean);
    void regFailure(Throwable throwable);
}
