package com.jd.imitate2jd.appmvps.cart.model;

import com.jd.imitate2jd.api.ApiConfig;
import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;
import com.jd.imitate2jd.utils.RetrofitManager;

import io.reactivex.Observable;

public class CartModel implements ICartModel{
    @Override
    public Observable<GetCart> modelData(String uid) {
        return RetrofitManager.getRetrofitManager().create(ApiConfig.class).getCarts(uid);
    }
}
