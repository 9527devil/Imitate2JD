package com.jd.imitate2jd.appmvps.ddetail.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.ddetail.mvp.model.bean.DdetailBean;
import com.jd.imitate2jd.appmvps.ddetail.mvp.presenter.DdetailPresenter;
import com.jd.imitate2jd.base.BaseActivity;
import com.jd.imitate2jd.main.MainActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DdetailActivity extends BaseActivity<DdetailPresenter> implements IDdetailView {

    private static final String TAG = "DdetailActivity";
    DdetailPresenter mPresenter;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.checkcard)
    Button checkcard;
    @BindView(R.id.addcard)
    Button addcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddetail);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideLayout() {
        return R.layout.activity_ddetail;
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected DdetailPresenter providerPresenter() {
        if (mPresenter == null) {
            mPresenter = new DdetailPresenter(this);
            return mPresenter;
        } else {
            return mPresenter;
        }
    }


    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        Toast.makeText(this, getIntent().getStringExtra("pid"), Toast.LENGTH_SHORT).show();
        mPresenter.ddetailPresenter(getIntent().getStringExtra("pid"));
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void ddetailSuccess(DdetailBean ddetailBean) {
            String[] split = ddetailBean.getData().getImages().split("\\|");
            List<String> list = new ArrayList<>(Arrays.asList(split));
        banner.setImageLoader(new MyLoader()).setImages(list).start();
        checkcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DdetailActivity.this,MainActivity.class);
                intent.putExtra("goCart",true);
                startActivity(intent);
            }
        });
        addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public void ddetailFailure(Throwable throwable) {

    }

    @Override
    public Context context() {
        return this;
    }
    
    class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
