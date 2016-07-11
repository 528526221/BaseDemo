package com.xulc.basedemo.app;

import com.xulc.basedemo.util.ToastUtil;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * Created by xuliangchun on 2016/7/8.
 */
public class HttpHelper {
    private static HttpHelper helper;
    private static FinalHttp finalHttp;
    public static HttpHelper getInstance(){
        if (helper==null||finalHttp==null){
            helper = new HttpHelper();
            finalHttp = new FinalHttp();
        }
        return helper;
    }

    public void HttpGet(String url, final int code, final HttpListener listener){
        finalHttp.get(url, new AjaxCallBack<Object>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public int getRate() {
                return super.getRate();
            }

            @Override
            public AjaxCallBack<Object> progress(boolean progress, int rate) {
                return super.progress(progress, rate);
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                listener.onSuccess(code,o.toString());

            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                listener.onFailure(code,strMsg);
                ToastUtil.show(strMsg);
            }
        });
    }

    public void HttpPost(String url,AjaxParams params, final int code, final HttpListener listener){
        finalHttp.post(url, params, new AjaxCallBack<Object>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public int getRate() {
                return super.getRate();
            }

            @Override
            public AjaxCallBack<Object> progress(boolean progress, int rate) {
                return super.progress(progress, rate);
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                listener.onSuccess(code,o.toString());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                listener.onFailure(code,strMsg);
                ToastUtil.show(strMsg);

            }
        });
    }

}
