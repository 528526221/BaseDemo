package com.xulc.basedemo.app;

/**
 * Created by xuliangchun on 2016/7/8.
 * 数据请求必须实现的接口
 * 成功和失败回调
 */
public interface HttpListener {
    void onSuccess(int code,String result);
    void onFailure(int code,String msg);
}
