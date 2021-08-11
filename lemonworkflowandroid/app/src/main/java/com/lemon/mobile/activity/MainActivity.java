package com.lemon.mobile.activity;

import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.lemon.mobile.R;
import com.lemon.mobile.base.BaseActivity;
import com.lemon.mobile.fragment.MyFragment;
import com.lemon.mobile.fragment.StatisticFragment;
import com.lemon.mobile.fragment.TaskFragment;

public class MainActivity extends BaseActivity {

    private FrameLayout fl;
    private RadioGroup rg;
    private Fragment homeFm = null, staFm = null, myFm = null;

    private final class RadioGroupOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            if (homeFm != null) {
                getSupportFragmentManager().beginTransaction().hide(homeFm).commit();
            }
            if (staFm != null) {
                getSupportFragmentManager().beginTransaction().hide(staFm).commit();
            }
            if (myFm != null) {
                getSupportFragmentManager().beginTransaction().hide(myFm).commit();
            }
            switch (checkedId) {
                case R.id.rb_home:
                    if (homeFm == null) {
                        homeFm = new TaskFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, homeFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(homeFm).commit();
                    }
                    break;
                case R.id.rb_statistic:
                    if (staFm == null) {
                        staFm = new StatisticFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, staFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(staFm).commit();
                    }
                    break;
                case R.id.rb_my:
                    if (myFm == null) {
                        myFm = new MyFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.fl, myFm).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(myFm).commit();
                    }
                    break;
            }
        }
    }

    @Override
    public int getContentViewResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);
    }

    @Override
    protected void initData() {
//动态获取内存存储权限
//Manifest.permission.ACCESS_COARSE_LOCATION,
//Manifest.permission.ACCESS_FINE_LOCATION,
//Manifest.permission.WRITE_EXTERNAL_STORAGE,
//Manifest.permission.READ_EXTERNAL_STORAGE,
//Manifest.permission.READ_PHONE_STATE
        /*if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_EXTERNAL_STORAGE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.CAMERA},
                        1);
            }
        }*/
    }

    @Override
    protected void initList() {
        rg.setOnCheckedChangeListener(new RadioGroupOnCheckedChangeListener());
        rg.check(R.id.rb_home);
    }

}
