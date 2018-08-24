package com.jd.imitate2jd.appmvps.own.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.login.view.LoginActivity;
import com.jd.imitate2jd.base.BaseFragment;
import com.jd.imitate2jd.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class OwnPageFragment extends BaseFragment {

    @BindView(R.id.title_tv_own)
    TextView titleTvOwn;
    @BindView(R.id.set_img_own)
    ImageView setImgOwn;
    @BindView(R.id.msg_img_own)
    ImageView msgImgOwn;
    @BindView(R.id.own_userimg)
    ImageView ownUserimg;
    @BindView(R.id.own_login_reg)
    TextView ownLoginReg;
    Unbinder unbinder;

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
        return R.layout.ownpage_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.set_img_own, R.id.msg_img_own, R.id.own_userimg, R.id.own_login_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_img_own:
                break;
            case R.id.msg_img_own:
                break;
            case R.id.own_userimg:
                break;
            case R.id.own_login_reg:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
