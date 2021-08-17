package com.lemon.mobile.activity;

import android.text.TextUtils;
import android.widget.Button;

import com.lemon.mobile.R;
import com.lemon.mobile.base.BaseActivity;
import com.lemon.mobile.bean.FinishTaskRequestBean;
import com.lemon.mobile.util.GsonUtils;
import com.lemon.mobile.util.ToastUtils;
import com.lemon.mobile.util.UrlFactory;

/**
 * 完成待办任务
 *
 * @author Administrator
 */
public class FinishTaskActivity extends BaseActivity {
    private static final String TAG = "FinishTaskActivity";
    private Button finishTask;
    private String taskId;

    @Override
    public int getContentViewResource() {
        return R.layout.activity_finish_task;
    }

    @Override
    protected void initView() {
        UpTitle("任务详情");
        finishTask = findViewById(R.id.btn_finish);
    }

    @Override
    protected void initData() {
        taskId = getIntent().getStringExtra("taskId");
    }

    @Override
    protected void initList() {
        finishTask.setOnClickListener(v -> {
            FinishTaskRequestBean finishTaskRequestBean = new FinishTaskRequestBean();
            finishTaskRequestBean.setAction("complete");
            String s = GsonUtils.toJson(finishTaskRequestBean);
            okPostRequest("finish", UrlFactory.BaseUrl + "/process-api/runtime/tasks/" + taskId, s, null, "正在完成……", true);
        });
    }

    @Override
    protected void okResponseSuccess(String whit, Object t) {
        super.okResponseSuccess(whit, t);
        if (!TextUtils.equals(whit, "finish")) {
            return;
        }
        try {
            Integer datas = (Integer) t;
            if (datas == 200) {
                ToastUtils.showCenterToast(mContext, "已完成任务");
                finish();
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}