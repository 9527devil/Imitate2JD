package com.jd.imitate2jd.appmvps.cart.presenter;

import com.jd.imitate2jd.appmvps.cart.model.CartModel;
import com.jd.imitate2jd.appmvps.cart.model.ICartModel;
import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;
import com.jd.imitate2jd.appmvps.cart.view.ICartView;
import com.jd.imitate2jd.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CartPresenter extends BasePresenter<ICartView> {
    ICartView mView;
    ICartModel mModel;
    public CartPresenter(ICartView mIView) {
        super(mIView);
        this.mView = mIView;
    }

    @Override
    protected void initModel() {
        mModel = new CartModel();
    }

    public void presenterData(String uid){
        mModel.modelData(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetCart>() {
                    @Override
                    public void accept(GetCart getCart) throws Exception {
                        mView.viewSuccess(getCart);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.viewFailure(throwable);
                    }
                });
    }
}
