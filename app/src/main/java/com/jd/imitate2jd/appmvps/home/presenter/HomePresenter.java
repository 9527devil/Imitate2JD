package com.jd.imitate2jd.appmvps.home.presenter;

import android.util.Log;

import com.jd.imitate2jd.appmvps.home.model.HomeModel;
import com.jd.imitate2jd.appmvps.home.model.IHomeModel;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.appmvps.home.view.IHomePage;
import com.jd.imitate2jd.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter extends BasePresenter<IHomePage> {
    private static final String TAG = "HomePresenter";
    private IHomePage mHomeView;
    private IHomeModel mHomeModel;

    public HomePresenter(IHomePage mIView) {
        super(mIView);
        this.mHomeView = mIView;
    }

    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
    }

    public void bannerPresenter() {
        mHomeModel.bannerModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        Log.d(TAG, "bannerBean: "+"成功");
                        mHomeView.homeSuccess(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void pagerPresenter(){
        mHomeModel.pagerModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PagerBean>() {
                    @Override
                    public void accept(PagerBean pagerBean) throws Exception {
                        mHomeView.pagerSuccess(pagerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
