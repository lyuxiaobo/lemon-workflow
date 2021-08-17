package com.lemon.mobile.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.lemon.mobile.R;

/**
 * 加载对话框
 * @author Lyubo
 * @date 2021/8/14
 */
public class CbLoadingDialog extends ProgressDialog
{

    private TextView tvMessage;
    private CharSequence message;
    private int progressColor = -1;

    public CbLoadingDialog(Context context)
    {
        super(context, R.style.CbLoadingDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init(getContext());
    }
    private void init(Context context)
    {
        setCancelable(true);

        //设置不可取消，点击其他区域不能取消
        setCanceledOnTouchOutside(false);

        setContentView(R.layout.c_progress_dialog);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        tvMessage = findViewById(R.id.progress_dialog_message);
        tvMessage.setText(message);
        if (TextUtils.isEmpty(message)){tvMessage.setVisibility(View.GONE);}
    }

    @Override
    public void setMessage(CharSequence message) {
        this.message = message;
        if (tvMessage != null) {
            tvMessage.setText(message);
        }
    }

    public void Cancelable(boolean b){
        setCancelable(b);
    }
}
