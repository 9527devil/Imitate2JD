package com.jd.imitate2jd.appmvps.reg.presenter;

import com.jd.imitate2jd.appmvps.reg.model.RegModel;
import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.appmvps.reg.view.IRegView;
import com.jd.imitate2jd.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegPresenter extends BasePresenter<IRegView> {
    private IRegView mRegView;
    private RegModel mRegModel;
    public RegPresenter(IRegView mIView) {
        super(mIView);
        mRegView = mIView;
    }

    @Override
    protected void initModel() {
        mRegModel = new RegModel();
    }

    public void presenterReg(String mobile,String password){
        mRegModel.modelReg(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(RegBean bean) throws Exception {
                        mRegView.regSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mRegView.regFailure(throwable);
                    }
                });
    }
}
