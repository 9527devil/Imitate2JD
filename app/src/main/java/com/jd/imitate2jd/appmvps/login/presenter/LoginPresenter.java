package com.jd.imitate2jd.appmvps.login.presenter;

import com.jd.imitate2jd.appmvps.login.model.LoginModel;
import com.jd.imitate2jd.appmvps.login.model.bean.LoginBean;
import com.jd.imitate2jd.appmvps.login.view.ILoginView;
import com.jd.imitate2jd.base.BasePresenter;
import com.jd.imitate2jd.base.IView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<ILoginView> {
    private ILoginView mILoginView;
    private LoginModel mLoginModel;
    public LoginPresenter(ILoginView mIView) {
        super(mIView);
        mILoginView = mIView;
    }

    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
    }

    public void presenterLogin(String mobile,String password){
        mLoginModel.modelLogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
                        mILoginView.loginSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mILoginView.loginFailure(throwable);
                    }
                });
    }
}
