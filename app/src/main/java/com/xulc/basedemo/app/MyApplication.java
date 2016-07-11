package com.xulc.basedemo.app;

import android.app.Activity;
import android.app.Application;
import android.util.DisplayMetrics;


import com.xulc.basedemo.widget.WaitDialog;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuliangchun on 2016/7/8.
 */
public class MyApplication extends Application {
    /** Activity管理 */
    private static List<Activity> mActivityList = new LinkedList<Activity>();
    private static MyApplication myApplication;
    private static WaitDialog waitDialog;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Resolution.setResolution(metrics.widthPixels, metrics.heightPixels, metrics.density);
//        ImageLoaderOptions.config(this);
        /** 数据库初始化 */
        DBHelper.init(this);
        /** 加载图片初始化 */
        BitMapHelper.init(this);
    }

    /**
     * application单例
     * @return
     */
    public static MyApplication getInstance(){
        return myApplication;
    }

    /**
     * 添加一个 activity到数组中
     */
    public void pushActivity(Activity activity) {
        mActivityList.add(activity);
    }

    /**
     *去除当前数组的中的一个activity
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            mActivityList.remove(activity);
        }
    }

    /**
     * 关闭数组中名字是itName以外的activity
     * @param itName 类名
     */
    public void closeOtherActivities(String itName) {
        for (Activity iter : mActivityList) {
            if (null != iter) {
                String activityName = iter.getClass().getSimpleName();

                if (!activityName.equalsIgnoreCase(itName))
                    iter.finish();
            }
        }
    }


    /**
     *  关闭所有的 activity
     */
    public void killAllActivity() {
        for (Activity iter : mActivityList) {
            if (null != iter)
                iter.finish();
        }
    }



}
