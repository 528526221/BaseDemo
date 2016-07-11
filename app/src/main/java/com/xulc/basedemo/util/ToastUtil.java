package com.xulc.basedemo.util;

import android.widget.Toast;

import com.xulc.basedemo.app.MyApplication;


/**
 * Created by xuliangchun on 2016/7/8.
 * 单例toast
 * 很短时间内调用多次show可能会造成只显示最后一次文本的现象
 */
public class ToastUtil {
    private static Toast toast = null ;
    public static void show(CharSequence msg){
        if (toast==null){
            toast = Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

}
