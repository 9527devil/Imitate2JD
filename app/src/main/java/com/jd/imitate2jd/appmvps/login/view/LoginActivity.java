package com.jd.imitate2jd.appmvps.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.login.model.bean.LoginBean;
import com.jd.imitate2jd.appmvps.login.presenter.LoginPresenter;
import com.jd.imitate2jd.appmvps.reg.model.bean.RegBean;
import com.jd.imitate2jd.appmvps.reg.view.IRegView;
import com.jd.imitate2jd.appmvps.reg.view.RegActivity;
import com.jd.imitate2jd.base.BaseActivity;
import com.jd.imitate2jd.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {


    private static final String TAG = "LoginActivity";
    @BindView(R.id.close_login)
    ImageView closeLogin;
    @BindView(R.id.login_kefu)
    TextView loginKefu;
    @BindView(R.id.username_et_login)
    EditText usernameEtLogin;
    @BindView(R.id.password_et_login)
    EditText passwordEtLogin;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.reg_tv_login)
    TextView regTvLogin;
    @BindView(R.id.login_remb)
    CheckBox loginRemb;
    @BindView(R.id.login_do)
    CheckBox loginDo;

    private boolean mIsDoLogin = false;
    private boolean mIsRemb = false;
    private LoginPresenter mPresenter;
    private SharedPreferences mShared ;

    @Override
    protected int provideLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected LoginPresenter providerPresenter() {
        if (mPresenter == null) {
            mPresenter = new LoginPresenter(this);
            return mPresenter;
        } else {
            return mPresenter;
        }
    }


    @Override
    protected void initViews() {
        mShared = getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {
        loginDo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mIsDoLogin = true;
                    loginRemb.setChecked(true);
                } else {
                    mIsDoLogin = true;
                }
            }
        });
        loginRemb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mIsRemb = true;
                } else {
                    mIsRemb = false;
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

    @OnClick({R.id.close_login, R.id.login_kefu, R.id.login_btn, R.id.reg_tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_login:
                finish();
                break;
            case R.id.login_kefu:
                break;
            case R.id.login_btn:
                mPresenter.presenterLogin(usernameEtLogin.getText().toString(),passwordEtLogin.getText().toString());
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.reg_tv_login:
                Intent intent = new Intent(this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public Context context() {
        return this;
    }

    @Override
    public void loginSuccess(LoginBean bean) {
       if(bean.getCode().equals("0")){
           Log.d(TAG, "loginSuccess: "+bean.getData().getUid());
           SharedPreferences.Editor editor = mShared.edit();
           editor.putString("uid",bean.getData().getUid());
           editor.putBoolean("isLogin",true);
           editor.putString("token",bean.getData().getToken());
           editor.commit();

           Log.d(TAG, "loginSuccess: "+bean.getMsg());

       }else{
           Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    public void loginFailure(Throwable throwable) {
        Log.d(TAG, "loginFailure: "+throwable.getMessage());
    }
}
