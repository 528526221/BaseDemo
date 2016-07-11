package com.xulc.basedemo.widget;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.xulc.basedemo.R;


/**
 * 自定义等待框
 * Created by xuliangchun on 2016/7/8.
 */
public class WaitDialog extends ProgressDialog {
    private AnimationDrawable mAnimation;
    private ImageView mImageView;

    public WaitDialog(Context context) {
        super(context);
//        super(context, R.style.Theme_Light_NoTitle_NoShadow_Dialog);//去掉dialog的阴影效果
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });

    }



    private void initView() {
        setContentView(R.layout.loading);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
    }

	/*@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		mAnimation.start();
		super.onWindowFocusChanged(hasFocus);
	}*/
}
