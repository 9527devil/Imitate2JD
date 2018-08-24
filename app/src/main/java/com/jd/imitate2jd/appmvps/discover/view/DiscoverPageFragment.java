package com.jd.imitate2jd.appmvps.discover.view;


import com.jd.imitate2jd.R;
import com.jd.imitate2jd.base.BaseFragment;
import com.jd.imitate2jd.base.BasePresenter;

public class DiscoverPageFragment extends BaseFragment {

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {

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
        return R.layout.discoverpage_fragment;
    }
}
