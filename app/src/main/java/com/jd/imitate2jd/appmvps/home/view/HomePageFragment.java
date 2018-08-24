package com.jd.imitate2jd.appmvps.home.view;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.app.MyApp;
import com.jd.imitate2jd.appmvps.home.adapter.MyHomeAdapter;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.appmvps.home.presenter.HomePresenter;
import com.jd.imitate2jd.base.BaseFragment;
import com.jd.imitate2jd.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomePageFragment extends BaseFragment<HomePresenter> implements IHomePage{

    @BindView(R.id.recyc_homepage)
    RecyclerView mRecyc;
    private static final String TAG = "HomePageFragment";
    private HomePresenter mHomePresenter;
    private MyHomeAdapter myHomeAdapter;
    List<PagerBean.DataBean> list;

    @Override
    protected HomePresenter providerPresenter() {
        if(mHomePresenter==null){
            mHomePresenter = new HomePresenter(this);
            return mHomePresenter;
        }else{
            return mHomePresenter;
        }
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initData() {
        mHomePresenter.bannerPresenter();
        mHomePresenter.pagerPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected Object providerBindView() {
        return this;
    }

    @Override
    protected int provideLayout() {
        return R.layout.homepage_fragment;
    }

    @Override
    public void homeSuccess(BannerBean bannerBean) {
        Log.d(TAG, "homeSuccess: "+bannerBean);
        myHomeAdapter = new MyHomeAdapter(getContext(),bannerBean);
        myHomeAdapter.setmList(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyc.setLayoutManager(linearLayoutManager);
        mRecyc.setAdapter(myHomeAdapter);

    }

    @Override
    public void homeFailure(Throwable throwable) {

    }

    @Override
    public void pagerSuccess(PagerBean pagerBean) {
        list = new ArrayList<>();
        for (int i = 0; i < pagerBean.getData().size(); i++) {
            list.add(pagerBean.getData().get(i));
        }
    }

    @Override
    public void pagerFailure(Throwable throwable) {

    }

    @Override
    public Context context() {
        return getContext();
    }
}
