 package com.lemon.mobile.base;

 import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
 import android.util.Log;
 import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.lemon.mobile.R;
 import com.lemon.mobile.util.ActivityCollectorUtil;
 import com.lemon.mobile.util.CbLoadingDialog;
import com.lemon.mobile.util.GsonUtils;
import com.lemon.mobile.util.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import java.util.List;


 public abstract class BaseActivity extends AppCompatActivity {
     private static final String TAG = "BaseActivity";
    public Context mContext;
    public Bundle savedInstanceState;
    public ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());
        ActivityCollectorUtil.addActivity(this);

        this.savedInstanceState = savedInstanceState;
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();  //所有子类都将继承这些相同的属性
        mContext = this;
        initView();
        initData();
        initList();
    }

    public void start(Class clazz) {
        startActivity(new Intent(mContext, clazz));
    }

    public abstract int getContentViewResource();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initList();

    public void UpTitle(String title) {
        if (findViewById(R.id.vBar) == null) {
            return;
        }
        mImmersionBar.titleBar(R.id.vBar).statusBarDarkFont(true, 0.2f).init();
        findViewById(R.id.tvTitleBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.tvTitleBar)).setText(title == null ? "" : title);
    }



     public void okGetRequest(String url) {
         okGetRequest(null, url, null);
     }

     public void okGetRequest(String with, String url) {
         okGetRequest(with, url, null);
     }

     public void okGetRequest(String with, String url, List<Object> params) {
         okGetRequest(with, url, params, null, null, false);
     }

     public void okGetRequest(String with, String url, List<Object> params, Class clazz, String dialogMsg, boolean isDialog) {
         if (TextUtils.isEmpty(with)) {
             with = url;
         }
         String finalWith = with;
         if (params != null) {
             for (int i = 0; i < params.size(); i++) {
                 url = url + "/" + params.get(i);
             }
         }
         OkGo.<String>get(url).execute(new StringCallback() {
             @Override
             public void onStart(com.lzy.okgo.request.base.Request<String, ? extends com.lzy.okgo.request.base.Request> request) {
                 super.onStart(request);
                 if (isDialog) {
                     showProgressDialog(dialogMsg);
                 }
                 okResponseStart(finalWith);
             }

             @Override
             public void onSuccess(com.lzy.okgo.model.Response<String> response) {
//                L.out(finalWith + "请求结果:__", response.body());
                 okResponseSuccess(finalWith, response.body());
             }

             @Override
             public void onError(com.lzy.okgo.model.Response<String> response) {
                 super.onError(response);
                 okResponseError(finalWith, response.body());
             }

             @Override
             public void onFinish() {
                 super.onFinish();
                 if (isDialog) dismissProgressDialog();
                 okResponseFinish(finalWith);
             }
         });
     }

     public void okPostRequest(final String what, final String httpurl, HttpParams params, final Class clazz) {
         okPostRequest(what, httpurl, params, clazz, null, false);
     }

     /**
      * OK网络请求
      *
      * @param httpurl      请求URl 也用来标记
      * @param params       请求参数
      * @param clazz        返回的Bean对象
      * @param DialogMsg    弹出Dialog的文字消息
      * @param isShowDialog 是否弹出Dialog 默认弹出
      */
     public void okPostRequest(String what, String httpurl, HttpParams params, final Class clazz, final String DialogMsg, final boolean isShowDialog) {
         final String url = httpurl;
         final String finalWhat = TextUtils.isEmpty(what) ? url : what;
         OkGo.<String>post(url).params(params).execute(new StringCallback() {
             @Override
             public void onStart(com.lzy.okgo.request.base.Request<String, ? extends com.lzy.okgo.request.base.Request> request) {
                 super.onStart(request);
                 if (isShowDialog) {
                     showProgressDialog(DialogMsg);
                 }
                 okResponseStart(finalWhat);
             }

             @Override
             public void onSuccess(com.lzy.okgo.model.Response<String> response) {
//                L.out(finalWhat + "请求结果:__", response.body());
                 if (clazz == null) {
                     okResponseSuccess(finalWhat, response.body());
                 } else {
                     try {
                         Object bean = GsonUtils.fromJson(response.body(), clazz);
                         okResponseSuccess(finalWhat, bean);
                     } catch (Exception e) {
                         okResponseSuccess(finalWhat, null);
                         ToastUtils.GsonExtremely();
                     }
                 }
             }

             @Override
             public void onError(com.lzy.okgo.model.Response<String> response) {
                 super.onError(response);
//                L.out(finalWhat + "请求结果:__", response.body());
                 okResponseError(finalWhat, response.body());
                 ToastUtils.failNetRequest();
             }

             @Override
             public void onFinish() {
                 super.onFinish();
                 if (isShowDialog) {
                     dismissProgressDialog();
                 }
                 okResponseFinish(finalWhat);
             }
         });
     }

     /**
      * OK网络请求
      *
      * @param httpurl      请求URl 也用来标记
      * @param clazz        返回的Bean对象
      * @param DialogMsg    弹出Dialog的文字消息
      * @param isShowDialog 是否弹出Dialog 默认弹出
      */
     public void okPostRequest(String what, String httpurl, String json, final Class clazz, final String DialogMsg, final boolean isShowDialog) {
         final String url = httpurl;
         final String finalWhat = TextUtils.isEmpty(what) ? url : what;

         OkGo.<String>post(url).upString(json, HttpParams.MEDIA_TYPE_JSON).execute(new StringCallback() {
             @Override
             public void onStart(com.lzy.okgo.request.base.Request<String, ? extends com.lzy.okgo.request.base.Request> request) {
                 super.onStart(request);
                 if (isShowDialog) {
                     showProgressDialog(DialogMsg);
                 }
                 okResponseStart(finalWhat);
             }

             @Override
             public void onSuccess(com.lzy.okgo.model.Response<String> response) {
//                L.out(finalWhat + "请求结果:__", response.body());
                 Log.i(TAG, "onSuccess: " + response.code());
                 if (clazz == null) {
                     okResponseSuccess(finalWhat, response.code());
                 } else {
                     try {
                         Object bean = GsonUtils.fromJson(response.body(), clazz);
                         okResponseSuccess(finalWhat, bean);
                     } catch (Exception e) {
                         okResponseSuccess(finalWhat, null);
                         ToastUtils.GsonExtremely();
                     }
                 }
             }

             @Override
             public void onError(com.lzy.okgo.model.Response<String> response) {
                 super.onError(response);
//                L.out(finalWhat + "请求结果:__", response.body());
                 Log.i(TAG, "onError: " + response.code());
                 okResponseError(finalWhat, response.body());
             }

             @Override
             public void onFinish() {
                 super.onFinish();
                 if (isShowDialog) {
                     dismissProgressDialog();
                 }
                 okResponseFinish(finalWhat);
             }
         });
     }

     /**
      * OK网络请求成功回调
      *
      * @param whit 请求标记
      * @param t    返回结果
      */
     protected void okResponseSuccess(String whit, Object t) {
     }

     /**
      * OK网络请求失败（错误）回调
      *
      * @param whit
      * @param body
      */
     protected void okResponseError(String whit, String body) {
     }

     /**
      * OK网络开始请求回调
      *
      * @param flag
      */
     protected void okResponseStart(String flag) {
     }

     /**
      * OK网络请求完成回调
      *
      * @param flag
      */
     protected void okResponseFinish(String flag) {
     }


    private CbLoadingDialog mProgressDialog;

    public void showProgressDialog(String msg) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new CbLoadingDialog(mContext);
        }
        if (!TextUtils.isEmpty(msg)) {
            this.mProgressDialog.setMessage(msg);
        } else {
            this.mProgressDialog.setMessage("");
        }
        this.mProgressDialog.show();
    }

    public void dismissProgressDialog() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtil.removeActivity(this);
        if (mImmersionBar != null) {

            //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
    }
}
