package com.jd.imitate2jd.appmvps.sort.view;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.sort.adapter.MyInfoAdapter;
import com.jd.imitate2jd.appmvps.sort.adapter.MyMenuAdapter;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;
import com.jd.imitate2jd.appmvps.sort.presenter.SortPresenter;
import com.jd.imitate2jd.base.BaseFragment;
import com.jd.imitate2jd.detail.mvp.view.DetailActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SortPageFragment extends BaseFragment<SortPresenter> implements ISortView {

    private static final String TAG = "SortPageFragment";
    private SortPresenter mPresenter;
    @BindView(R.id.sort_menu_recyc)
    RecyclerView mMenuRecyc;
    @BindView(R.id.sort_info_recyc)
    RecyclerView mInfoRecyc;

    @Override
    protected SortPresenter providerPresenter() {
        if (mPresenter == null) {
            return mPresenter = new SortPresenter(this);
        }
        return mPresenter;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {
        mPresenter.presenterMenu();
        mPresenter.presenterInfo("1");
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
        return R.layout.sortpage_fragment;
    }

    @Override
    public void getMenuSuccess(MenuBean menuBean) {
        Log.d(TAG, "getMenuSuccess: "+menuBean.getMsg());
        List<MenuBean.DataBean> menuList = new ArrayList<>();
        for (int i = 0; i < menuBean.getData().size(); i++) {
            menuList.add(menuBean.getData().get(i));
        }
        MyMenuAdapter myMenuAdapter = new MyMenuAdapter(menuList,getContext());
        mMenuRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        mMenuRecyc.setAdapter(myMenuAdapter);
        myMenuAdapter.setListener(new MyMenuAdapter.OnItemClickListener() {
            @Override
            public void Click(String cid) {
                mPresenter.presenterInfo(cid);
            }
        });

    }

    @Override
    public void getMenuFailure(Throwable throwable) {

    }

    @Override
    public void getInfoSuccess(InfoBean infoBean) {
        List<InfoBean.DataBean> list = new ArrayList<>();
        for (int i = 0; i < infoBean.getData().size(); i++) {
            list.add(infoBean.getData().get(i));
        }
        MyInfoAdapter myInfoAdapter = new MyInfoAdapter(list,getContext());
        mInfoRecyc.setLayoutManager(new GridLayoutManager(getContext(),3));
        mInfoRecyc.setAdapter(myInfoAdapter);
        myInfoAdapter.setOnItemClickListener(new MyInfoAdapter.OnItemClickListener() {
            @Override
            public void onCLick(String pscid) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("id",pscid);
                Log.d(TAG, "onCLick: "+pscid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getInfoFailure(Throwable throwable) {
        Log.d(TAG, "getInfoFailure: "+throwable.getMessage());
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
