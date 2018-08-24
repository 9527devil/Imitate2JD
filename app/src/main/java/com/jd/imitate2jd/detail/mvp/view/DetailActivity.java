package com.jd.imitate2jd.detail.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.ddetail.mvp.view.DdetailActivity;
import com.jd.imitate2jd.base.BaseActivity;
import com.jd.imitate2jd.detail.mvp.model.adapter.MyRecycAdapter;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;
import com.jd.imitate2jd.detail.mvp.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity<DetailPresenter> implements IDetailView {

    private static final String TAG = "DetailActivity";
    DetailPresenter detailPresenter;
    @BindView(R.id.detail_recyc)
    RecyclerView detailRecyc;

    @Override
    protected int provideLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected DetailPresenter providerPresenter() {
        if (detailPresenter == null) {
            detailPresenter = new DetailPresenter(this);
            return detailPresenter;
        } else {
            return detailPresenter;
        }
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        detailPresenter.detailPresenter(getIntent().getStringExtra("id"));
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void detailSuccess(DetailBean detailBean) {
        MyRecycAdapter myRecycAdapter = new MyRecycAdapter(detailBean, this);
        detailRecyc.setLayoutManager(new LinearLayoutManager(this));
        detailRecyc.setAdapter(myRecycAdapter);
        myRecycAdapter.setOnItemCLickListener(new MyRecycAdapter.OnItemCLickListener() {
            @Override
            public void Click(String pid) {
                Intent intent = new Intent(DetailActivity.this,DdetailActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void detailFailure(Throwable throwable) {

    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
