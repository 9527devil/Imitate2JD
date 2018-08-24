package com.jd.imitate2jd.appmvps.login.view;


import com.jd.imitate2jd.appmvps.login.model.bean.LoginBean;
import com.jd.imitate2jd.base.IView;

public interface ILoginView extends IView {
    void loginSuccess(LoginBean bean);
    void loginFailure(Throwable throwable);
}
