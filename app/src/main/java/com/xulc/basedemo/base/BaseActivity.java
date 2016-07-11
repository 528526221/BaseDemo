package com.xulc.basedemo.base;

import android.os.Bundle;


import com.xulc.basedemo.app.MyApplication;
import com.xulc.basedemo.widget.WaitDialog;

import net.tsz.afinal.FinalActivity;

/**
 * Created by xuliangchun on 2016/7/8.
 */
public abstract class BaseActivity extends FinalActivity {
    private WaitDialog waitDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().pushActivity(this);
        setContentView(setLayout());
        findView();
        setListener();
        underCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeWait();
        MyApplication.getInstance().popActivity(this);
    }

    /**
     * 设置上下文布局
     */
    public abstract int setLayout();

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

    public void showWait(){
        if (waitDialog==null){
            waitDialog = new WaitDialog(this);
        }
        if (!waitDialog.isShowing()){
            waitDialog.show();
        }
    }

    public void closeWait(){
        if (waitDialog!=null&&waitDialog.isShowing()){
            waitDialog.dismiss();
        }
    }

}
