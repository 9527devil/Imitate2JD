package com.jd.imitate2jd.appmvps.ddetail.mvp.presenter;

import com.jd.imitate2jd.appmvps.ddetail.mvp.model.DdetailModel;
import com.jd.imitate2jd.appmvps.ddetail.mvp.model.IDdetailModel;
import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;
import com.jd.imitate2jd.appmvps.ddetail.mvp.view.IDdetailView;
import com.jd.imitate2jd.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DdetailPresenter extends BasePresenter<IDdetailView>{
    IDdetailView mView;
    IDdetailModel mModel;
    public DdetailPresenter(IDdetailView mIView) {
        super(mIView);
        mView = mIView;
    }

    @Override
    protected void initModel() {
        mModel = new DdetailModel();
    }

    public void ddetailPresenter(String pid){
        mModel.ddetailModel(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DdetailBean>() {
                    @Override
                    public void accept(DdetailBean ddetailBean) throws Exception {
                        mView.ddetailSuccess(ddetailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.ddetailFailure(throwable);
                    }
                });
    }
}
