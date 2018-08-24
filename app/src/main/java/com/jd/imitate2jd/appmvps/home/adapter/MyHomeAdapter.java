package com.jd.imitate2jd.appmvps.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;
import com.jd.imitate2jd.myview.MyGridView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyHomeAdapter extends RecyclerView.Adapter {
    private static final String TAG = "MyHomeAdapter";
    private Context mContext;
    private BannerBean mBannerBean;
    private List<PagerBean.DataBean> mList;

    //放gridview的View
    List<View> mGrids;


    public void setmList(List<PagerBean.DataBean> mList) {
        this.mList = mList;
        Log.d(TAG, "setmList: " + mList.size());
    }

    public MyHomeAdapter(Context mContext, BannerBean mBannerBean) {
        this.mContext = mContext;
        this.mBannerBean = mBannerBean;
    }

    private static final int TYPEA = 0;
    private static final int TYPEB = 1;
    private static final int TYPEC = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder holder = null;
        if (TYPEA == i) {
            view = View.inflate(mContext, R.layout.item_banner, null);
            holder = new BannerHoler(view);
        } else if (TYPEB == i) {
            view = View.inflate(mContext, R.layout.item_pager, null);
            holder = new PagerHolder(view);
        } else if (TYPEC == i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_miao,null,false);
            holder = new MiaoHolder(v);
        }else{
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tui,null,false);
            holder = new TuiHolder(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BannerHoler) {
            List<String> images = new ArrayList<>();
            for (int j = 0; j < mBannerBean.getData().size(); j++) {
                images.add(mBannerBean.getData().get(j).getIcon());
            }
            ((BannerHoler) viewHolder).banner.setImageLoader(new MyLoader()).setImages(images).start();
            /**
             *
             * 此处是viewpager
             */
        } else if (viewHolder instanceof PagerHolder) {
            List<PagerBean.DataBean> lista = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                lista.add(mList.get(j));
            }
            mGrids = new ArrayList<>();
            View GoneViewa = View.inflate(mContext, R.layout.pager_gridview_a, null);
            GridView Ga = GoneViewa.findViewById(R.id.grid_a);
            MyGridViewAdapter myGridViewAdaptera = new MyGridViewAdapter(lista, mContext);
            Ga.setAdapter(myGridViewAdaptera);
            mGrids.add(GoneViewa);

            List<PagerBean.DataBean> listb = new ArrayList<>();
            for (int j = 10; j < 19; j++) {
                listb.add(mList.get(j));
            }
            View GoneViewb = View.inflate(mContext, R.layout.pager_gridview_b, null);
            GridView Gb = GoneViewb.findViewById(R.id.grid_b);
            MyGridViewAdapter myGridViewAdapterb = new MyGridViewAdapter(listb, mContext);
            Gb.setAdapter(myGridViewAdapterb);
            mGrids.add(GoneViewb);


            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(mGrids);
            ((PagerHolder) viewHolder).i1.setSelected(true);
            ((PagerHolder) viewHolder).pager.setAdapter(myPagerAdapter);
            ((PagerHolder) viewHolder).pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    if (i == 0) {
                        ((PagerHolder) viewHolder).i1.setSelected(true);
                        ((PagerHolder) viewHolder).i2.setSelected(false);
                    } else {
                        ((PagerHolder) viewHolder).i1.setSelected(false);
                        ((PagerHolder) viewHolder).i2.setSelected(true);
                    }
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
            /**
             *
             * 此处是秒杀
             */
        } else if (viewHolder instanceof MiaoHolder) {
            List<BannerBean.MiaoshaBean.ListBeanX> list = new ArrayList<>();
            for (int j = 0; j < mBannerBean.getMiaosha().getList().size(); j++) {
                list.add(mBannerBean.getMiaosha().getList().get(j));
            }
            MiaoGridAdapter miaoGridAdapter = new MiaoGridAdapter(mContext,list);
            ((MiaoHolder) viewHolder).miaogrid.setAdapter(miaoGridAdapter);
        } else if (viewHolder instanceof TuiHolder) {
            List<BannerBean.TuijianBean.ListBean> list = new ArrayList<>();
            for (int j = 0; j < mBannerBean.getTuijian().getList().size(); j++) {
                list.add(mBannerBean.getTuijian().getList().get(j));
            }
            MyTuiAdapter adapter = new MyTuiAdapter(list,mContext);
            ((TuiHolder) viewHolder).tuirecyc.setLayoutManager(new GridLayoutManager(mContext,3));
            ((TuiHolder) viewHolder).tuirecyc.setAdapter(adapter);

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    class BannerHoler extends RecyclerView.ViewHolder {

        private final Banner banner;

        public BannerHoler(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.item_banner);
        }
    }

    class PagerHolder extends RecyclerView.ViewHolder {

        private final ViewPager pager;
        ImageView i1, i2;

        public PagerHolder(@NonNull View itemView) {
            super(itemView);
            pager = itemView.findViewById(R.id.holder_pager);
            i1 = itemView.findViewById(R.id.iv_one);
            i2 = itemView.findViewById(R.id.iv_two);
        }
    }

    /**
     *
     * 此处是秒杀
     */
    class MiaoHolder extends RecyclerView.ViewHolder {

        private final MyGridView miaogrid;

        public MiaoHolder(@NonNull View itemView) {
            super(itemView);
            miaogrid = itemView.findViewById(R.id.miao_grid);
        }
    }

    /**
     *
     * 推荐t推荐推荐推荐推荐推荐推荐推荐     */
    class TuiHolder extends RecyclerView.ViewHolder {

        private final RecyclerView tuirecyc;

        public TuiHolder(@NonNull View itemView) {
            super(itemView);
            tuirecyc = itemView.findViewById(R.id.tui_recyc);
        }
    }

    class MyLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
