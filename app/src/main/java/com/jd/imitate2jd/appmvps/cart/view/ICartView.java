package com.jd.imitate2jd.appmvps.cart.view;

import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;
import com.jd.imitate2jd.base.IView;

public interface ICartView extends IView{
    void viewSuccess(GetCart getCart);
    void viewFailure(Throwable throwable);
}
