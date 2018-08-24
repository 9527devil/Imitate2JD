package com.jd.imitate2jd.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayout());

        ButterKnife.bind(provideBindView());

        mPresenter = providerPresenter();

        initViews();

        initDatas();

        initListener();
    }

    /**
     * 返回布局文件
     * @return
     */
    protected abstract int provideLayout();

    /**
     * 绑定Butterknife
     * @return
     */
    protected abstract Activity provideBindView();

    /**
     * 返回P层对象
     * @return
     */
    protected abstract P providerPresenter();

    /**
     * 初始化view层id
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 初始化监听事件
     */
    protected abstract void initListener();

    /**
     * 内存泄漏
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter = null;
            mPresenter.onDestroy();
        }
    }
}
