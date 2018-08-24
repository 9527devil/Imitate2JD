package com.jd.imitate2jd.appmvps.cart.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;
import com.jd.imitate2jd.appmvps.cart.presenter.CartPresenter;
import com.jd.imitate2jd.base.BaseFragment;
import com.jd.imitate2jd.base.BasePresenter;

public class CartPageFragment extends BaseFragment<CartPresenter> implements ICartView {

    private static final String TAG = "CartPageFragment";
    CartPresenter mPresenter;

    @Override
    protected CartPresenter providerPresenter() {
        if (mPresenter == null) {
            synchronized (CartPresenter.class) {
                if (mPresenter == null) {
                    mPresenter = new CartPresenter(this);
                    return mPresenter;
                }
            }
        }
        return  mPresenter;
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
        return R.layout.cartpage_fragment;
    }

    @Override
    public void viewSuccess(GetCart getCart) {

    }

    @Override
    public void viewFailure(Throwable throwable) {

    }

    @Override
    public Context context() {
        return getContext();
    }
}
