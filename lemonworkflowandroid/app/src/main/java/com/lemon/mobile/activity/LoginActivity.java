package com.lemon.mobile.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.lemon.mobile.R;
import com.lemon.mobile.base.BaseActivity;
import com.lemon.mobile.bean.LoginResultBean;
import com.lemon.mobile.util.SPUtils;
import com.lemon.mobile.util.ToastUtils;
import com.lemon.mobile.util.UrlFactory;
import com.lzy.okgo.model.HttpParams;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";

    private Button login;
    private EditText name;
    private EditText password;
    @Override
    public int getContentViewResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        login = findViewById(R.id.btn_login);
        name = findViewById(R.id.et_name);
        password= findViewById(R.id.et_password);
        mImmersionBar.titleBar(R.id.toolbar).keyboardEnable(true).init();
        login.setOnClickListener(v -> {
            HttpParams httpParams = new HttpParams();
            httpParams.put("name", name.getText().toString());
            httpParams.put("password", password.getText().toString());
            okPostRequest("login", UrlFactory.BaseUrl + "/login", httpParams, LoginResultBean.class, "正在登录……", true);

        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initList() {

    }

    @Override
    protected void okResponseSuccess(String whit, Object t) {
        super.okResponseSuccess(whit, t);

        if (!TextUtils.equals(whit,"login")) {
            return;
        }
        try{
            LoginResultBean datas = (LoginResultBean) t;
            if (datas.getCode() == 200) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                SPUtils.put(mContext, "username", datas.getData().getUserName());
            }else {
                ToastUtils.showCenterToast(mContext, datas.getMsg());
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

    }

}