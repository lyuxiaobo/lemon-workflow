package com.lemon.mobile.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gyf.immersionbar.ImmersionBar;
import com.lemon.mobile.R;
import com.lemon.mobile.base.BaseCacheFragment;
import com.lemon.mobile.base.BaseFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * CCB simple {@link } subclass.
 */
public class TaskFragment extends BaseFragment {
    private static final String TAG = "TaskFragment";

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    private MagicIndicator magicIndicator;
    private ViewPager viewPager;
    private List<BaseCacheFragment> mFragmentList;
    private List<String> mDataList = Arrays.asList("待办任务", "已办任务");


    @Override
    public void initView(View view) {
        magicIndicator = view.findViewById(R.id.task_indicator);
        viewPager = view.findViewById(R.id.task_view_pager);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.titleBar(magicIndicator).statusBarDarkFont(true).init();

        CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            long currentTime = 0;

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);

                simplePagerTitleView.setText(mDataList.get(i));
                simplePagerTitleView.setNormalColor(Color.parseColor("#606266"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#409EFF"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(i);

                        if (viewPager.getCurrentItem() == i && System.currentTimeMillis() - currentTime < 300) {
                            mFragmentList.get(i).onRefresh();
                            currentTime = 0;
                        }
                        currentTime = System.currentTimeMillis();
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator magicIndicator = new LinePagerIndicator(context);
                magicIndicator.setColors(Color.parseColor("#409EFF"));//下划线颜色
                return magicIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);


    }

    @Override
    public void loadData() {
//        GlideImageUtils.DisplayCircle(mContext, ResDatas.getGoodsImages().get(3),ivPhoto);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new TaskTodoFragment());
        mFragmentList.add(new TaskDoneFragment());
        viewPager.setAdapter(new Myadapter(getFragmentManager()));
    }

    @Override
    public void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        });
        viewPager.setCurrentItem(0);
    }

    class Myadapter extends FragmentPagerAdapter {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
