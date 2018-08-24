package com.jd.imitate2jd.appmvps.reg.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.appmvps.reg.presenter.RegPresenter;
import com.jd.imitate2jd.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegActivity extends BaseActivity<RegPresenter> implements IRegView {

    private static final String TAG = "RegActivity";
    RegPresenter mPresenter;
    @BindView(R.id.close_img_reg)
    ImageView closeImgReg;
    @BindView(R.id.reg_username)
    EditText regUsername;
    @BindView(R.id.reg_password)
    EditText regPassword;
    @BindView(R.id.reg_btn)
    Button regBtn;

    @Override
    protected int provideLayout() {
        return R.layout.activity_reg;
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected RegPresenter providerPresenter() {
        if (mPresenter == null) {
            mPresenter = new RegPresenter(this);
            return mPresenter;
        } else {
            return mPresenter;
        }
    }


    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void regSuccess(RegBean bean) {
        if (bean.getCode().trim().equals("0")) {
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void regFailure(Throwable throwable) {

    }

    @Override
    public Context context() {
        return this;
    }

    @OnClick(R.id.reg_btn)
    public void onViewClicked() {
        mPresenter.presenterReg(regUsername.getText().toString(), regPassword.getText().toString());
    }

    @OnClick(R.id.close_img_reg)
    public void onCloseClicked() {
        finish();
    }
}
