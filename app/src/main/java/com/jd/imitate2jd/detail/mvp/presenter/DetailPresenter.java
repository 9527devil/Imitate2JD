package com.jd.imitate2jd.detail.mvp.presenter;

import com.jd.imitate2jd.base.BasePresenter;
import com.jd.imitate2jd.detail.mvp.model.DetailModel;
import com.jd.imitate2jd.detail.mvp.model.IDetailModel;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.detail.mvp.view.IDetailView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter extends BasePresenter<IDetailView> {
    private IDetailView mDetailView;
    private IDetailModel mDetailModel;
    public DetailPresenter(IDetailView mIView) {
        super(mIView);
        this.mDetailView = mIView;
    }

    @Override
    protected void initModel() {
        this.mDetailModel = new DetailModel();
    }

    public void detailPresenter(String pscid){
        mDetailModel.detailModel(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailBean>() {
                    @Override
                    public void accept(DetailBean detailBean) throws Exception {
                        mDetailView.detailSuccess(detailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mDetailView.detailFailure(throwable);
                    }
                });
    }
}
