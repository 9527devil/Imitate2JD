package com.jd.imitate2jd.appmvps.cart.model;

import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;

import io.reactivex.Observable;

public interface ICartModel {
    Observable<GetCart> modelData(String uid);
}
