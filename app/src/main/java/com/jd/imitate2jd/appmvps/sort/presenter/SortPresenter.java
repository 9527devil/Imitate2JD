package com.jd.imitate2jd.appmvps.sort.presenter;

import android.util.Log;

import com.jd.imitate2jd.appmvps.sort.model.ISortModel;
import com.jd.imitate2jd.appmvps.sort.model.SortModel;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;
import com.jd.imitate2jd.appmvps.sort.view.ISortView;
import com.jd.imitate2jd.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SortPresenter extends BasePresenter<ISortView> {
    private static final String TAG = "SortPresenter";
    private ISortModel mModel;
    private ISortView mView;
    public SortPresenter(ISortView mIView) {
        super(mIView);
        this.mView = mIView;
    }

    @Override
    protected void initModel() {
        mModel = new SortModel();
    }

    public void presenterMenu(){
        mModel.modelMenu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MenuBean>() {
                    @Override
                    public void accept(MenuBean menuBean) throws Exception {
                        Log.d(TAG, "sortpresentermenusuccess: "+menuBean.getMsg());
                        mView.getMenuSuccess(menuBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "sortpresentermenufailure: "+throwable.getMessage());
                    }
                });
    }

    public void presenterInfo(String cid){
        mModel.modelInfo(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<InfoBean>() {
                    @Override
                    public void accept(InfoBean infoBean) throws Exception {
                        Log.d(TAG, "sortpresenterinfosuccess: "+infoBean.getMsg());
                        mView.getInfoSuccess(infoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "sortpresenterinfofailure: "+throwable.getMessage());
                    }
                });
    }
}
