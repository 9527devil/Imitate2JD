package com.jd.imitate2jd.base;

import android.content.Context;

import com.jd.imitate2jd.app.MyApp;

public abstract class BasePresenter<V extends IView> {
    private V mIView;

    public BasePresenter(V mIView) {
        this.mIView = mIView;

        initModel();
    }

    /**
     * 初始化Model层
     */
    protected abstract void initModel();

    /**
     * 防止内存泄漏
     */
    public void onDestroy() {
        mIView = null;
    }

    protected Context context() {
        if (mIView != null && mIView.context() != null) {
            return mIView.context();
        } else {
            return MyApp.getAppContext();
        }
    }

}
