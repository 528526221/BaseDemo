package com.xulc.basedemo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.tsz.afinal.FinalActivity;

/**
 * Created by xuliangchun on 2016/7/8.
 */
public abstract class BaseFragment extends Fragment {
    public View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            setContentView(inflater, container);
            findView();
            setListener();
            underCreate();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        FinalActivity.initInjectedView(this, rootView);
        return rootView;
    }

    /**
     * 设置上下文布局
     */
    protected abstract void setContentView(LayoutInflater inflater, ViewGroup container);

    /**
     * 初始化控件
     */
    public abstract void findView();

    /**
     * 设置监听器
     */
    public abstract void setListener();

    /**
     * onCreate()事件处理
     */
    public abstract void underCreate();
}
