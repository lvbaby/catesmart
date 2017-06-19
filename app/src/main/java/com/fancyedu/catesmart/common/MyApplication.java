package com.fancyedu.catesmart.common;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.fancyedu.catesmart.utils.LogUtil;
import com.fancyedu.catesmart.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyy on 2016/9/22.
 */
public class MyApplication extends MultiDexApplication {

    public static Context context = null;

    private List<Activity> activityList;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        activityList = new ArrayList<>();

        context = getApplicationContext();
        instance = this;
        ToastUtil.initToast(getApplicationContext());
        Fresco.initialize(this);
    }

    public static MyApplication getIntance() {
        return instance;
    }

    //添加
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 结束掉所有的activity
     */
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

}
