package com.lemon.mobile.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonSyntaxException;
import com.lemon.mobile.R;
import com.lemon.mobile.base.BaseCacheFragment;
import com.lemon.mobile.bean.TaskFinishedBean;
import com.lemon.mobile.util.FormatDate;
import com.lemon.mobile.util.GsonUtils;
import com.lemon.mobile.util.UrlFactory;


/**
 * Ccb simple {@link } subclass.
 */
public class TaskDoneFragment extends BaseCacheFragment {
    private static final String TAG = "TaskDoneFragment";
    private TasksAdapter tasksAdapter;

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    private RecyclerView recyclerView;

    @Override
    public void initView(View view) {
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        tasksAdapter = new TasksAdapter(R.layout.item_task);
        recyclerView.setAdapter(tasksAdapter);

        TextView tv = new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText("暂无数据!");
        // 没有数据的时候默认显示该布局
        tasksAdapter.setEmptyView(tv);

    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        recyclerView.scrollToPosition(0);
    }

    @Override
    public void loadData() {
        loadHttpData();
    }

    private int start = 0;
    private int size = 10;

    public void loadHttpData() {
        okGetRequest("getTasks", UrlFactory.BaseUrl + "/process-api/history/historic-task-instances?assignee=" + "admin" + "&size=" + size + "&start=" + start + "&finished=true");
    }

    @Override
    public void initListener() {
        tasksAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadHttpData();
            }
        }, recyclerView);
    }

    @Override
    protected void okResponseError(String whit, String body) {
        super.okResponseError(whit, body);
        TextView tv = new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText("加载失败!");
        tasksAdapter.setEmptyView(tv);

    }

    @Override
    protected void okResponseSuccess(String whit, Object t) {
        super.okResponseSuccess(whit, t);
        if (TextUtils.equals(whit, "getTasks")) {
            start = start + size;
            String json = String.valueOf(t);
            TaskFinishedBean datas = null;
            try {
                datas = GsonUtils.fromJson(json, TaskFinishedBean.class);
            } catch (JsonSyntaxException e) {
                e.fillInStackTrace();
            }
            if (datas == null) {
                return;
            }
            tasksAdapter.addData(datas.getData());
            if (datas.getSize() < size) {
                tasksAdapter.loadMoreEnd(true);
            }
        }
    }

    @Override
    protected void okResponseFinish(String flag) {
        super.okResponseFinish(flag);
        tasksAdapter.loadMoreComplete();
    }


    class TasksAdapter extends BaseQuickAdapter<TaskFinishedBean.DataBean, BaseViewHolder> {

        public TasksAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, TaskFinishedBean.DataBean item) {
            helper.setText(R.id.item_task_def, "流程定义：" + item.getProcessDefinitionId())
                    .setText(R.id.item_task_name, "任务名称：" + item.getName())
                    .setText(R.id.item_task_time, "创建时间：" + FormatDate.getDateStrFromISO8601Timestamp(item.getStartTime()));
        }
    }
}
