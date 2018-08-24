package com.jd.imitate2jd.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P mPresenter;
    private Unbinder mUnbinder;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(provideLayout(),container,false);
        mUnbinder = ButterKnife.bind(providerBindView(),mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providerPresenter();
        initViews();
        initData();
        initListener();
    }

    protected abstract P providerPresenter();

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract void initListener();


    protected abstract Object providerBindView();

    protected abstract int provideLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
