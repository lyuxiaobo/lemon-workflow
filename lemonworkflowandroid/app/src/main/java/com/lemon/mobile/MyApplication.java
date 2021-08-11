package com.lemon.mobile;

import android.content.Context;

import com.lemon.mobile.base.BaseApplication;
import com.lzy.okgo.OkGo;

/**
 * @Author cuiChenBo
 * Created by zz on 2018/3/6 11:57.
 * 　　class explain:
 * 　　　　update:       upAuthor:      explain:
 */

public class MyApplication extends BaseApplication {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        try {
            OkGo.getInstance().init(this);
        } catch (NoClassDefFoundError ncdfe) {
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 获取 上下文对象
     *
     * @return
     */
    public static Context getInstance() {
        return instance;
    }
}
