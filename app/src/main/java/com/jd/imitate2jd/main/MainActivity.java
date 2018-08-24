package com.jd.imitate2jd.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.cart.view.CartPageFragment;
import com.jd.imitate2jd.appmvps.discover.view.DiscoverPageFragment;
import com.jd.imitate2jd.appmvps.home.view.HomePageFragment;
import com.jd.imitate2jd.appmvps.own.view.OwnPageFragment;
import com.jd.imitate2jd.appmvps.sort.view.SortPageFragment;
import com.jd.imitate2jd.base.BaseActivity;
import com.jd.imitate2jd.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.fram_actvt)
    FrameLayout framActvt;
    @BindView(R.id.home_btn)
    RadioButton homeBtn;
    @BindView(R.id.sort_btn)
    RadioButton sortBtn;
    @BindView(R.id.discover_btn)
    RadioButton discoverBtn;
    @BindView(R.id.cart_btn)
    RadioButton cartBtn;
    @BindView(R.id.own_btn)
    RadioButton ownBtn;
    @BindView(R.id.group_actvt)
    RadioGroup groupActvt;

    private HomePageFragment mHomePage = null;
    private SortPageFragment mSortPage = null;
    private DiscoverPageFragment mDiscoverPage = null;
    private CartPageFragment mCartPage = null;
    private OwnPageFragment mOwnPage = null;
    private Fragment mCurrentFragment = null;

    @Override
    protected int provideLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Activity provideBindView() {

        return this;
    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected void initViews() {
        homeBtn.setChecked(true);

    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction
                    .hide(mCurrentFragment)
                    .add(R.id.fram_actvt, targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(mCurrentFragment)
                    .show(targetFragment)
                    .commit();
        }
        mCurrentFragment = targetFragment;
    }

    @Override
    protected void initDatas() {
        if (mCurrentFragment == null) {
            mHomePage = new HomePageFragment();
            mSortPage = new SortPageFragment();
            mDiscoverPage = new DiscoverPageFragment();
            mCartPage = new CartPageFragment();
            mOwnPage = new OwnPageFragment();
            mCurrentFragment = new Fragment();
            switchFragment(mHomePage);
        }
        boolean goCart = getIntent().getBooleanExtra("goCart", false);
        if(goCart){
            cartBtn.setChecked(goCart);
            switchFragment(mCartPage);
        }
    }

    @OnClick(R.id.group_actvt)
    @Override
    protected void initListener() {
        groupActvt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_btn:
                        switchFragment(mHomePage);
                        break;
                    case R.id.sort_btn:
                        switchFragment(mSortPage);
                        break;
                    case R.id.discover_btn:
                        switchFragment(mDiscoverPage);
                        break;
                    case R.id.cart_btn:
                        switchFragment(mCartPage);
                        break;
                    case R.id.own_btn:
                        switchFragment(mOwnPage);
                        break;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
