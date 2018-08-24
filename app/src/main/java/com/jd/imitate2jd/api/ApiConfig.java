package com.jd.imitate2jd.api;

import com.jd.imitate2jd.appmvps.cart.model.bean.GetCart;
import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.appmvps.login.model.bean.LoginBean;
import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConfig {
    /**
     * https://www.zhaoapi.cn/ad/getAd
     * 这是轮播图
     * @return
     */
    @GET("ad/getAd")
    Observable<BannerBean> getBannerUrl();
    /**
     * https://www.zhaoapi.cn/product/getCatagory
     * 这是viewpager
     */
    @GET("product/getCatagory")
    Observable<PagerBean> getPagerUrl();

    //------------分类------------------

    /**
     * product/getCatagory
     * 这是左边的商品分类接口
     * @return Observable
     */
     @GET("product/getCatagory")
    Observable<MenuBean> getMenuUrl();

    /**
     * https://www.zhaoapi.cn/product/getProductCatagory
     *这是右边的商品自分类接口
     * @return Observable
     */
    @GET("product/getProductCatagory")
    Observable<InfoBean> getInfoUrl(@Query("cid") String cid);

    /**
     *
     */
    @GET("product/product/getProducts")
    Observable<DetailBean> getDetail(@Query("pscid") String pscid);

    @GET("user/reg")
    Observable<RegBean> getReg(@Query("mobile") String mobile,@Query("password") String password);

    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile,@Query("password") String password);

    @GET("product/getProductDetail")
    Observable<DdetailBean> getDdetail(@Query("pid") String pic);

    @GET("product/getCarts")
    Observable<GetCart> getCarts(@Query("uid") String uid);
}
