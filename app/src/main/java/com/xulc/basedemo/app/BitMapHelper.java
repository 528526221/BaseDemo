package com.xulc.basedemo.app;

import android.content.Context;

import com.xulc.basedemo.R;

import net.tsz.afinal.FinalBitmap;

/**
 * Created by xuliangchun on 2016/7/11.
 */
public class BitMapHelper {
    private static FinalBitmap fb;
    private static Context APPLICATION_CONTEXT;


    public static void init(Context context) {
        APPLICATION_CONTEXT = context;
    }
    public static FinalBitmap getInstance(){
        if (fb==null){
            fb = FinalBitmap.create(APPLICATION_CONTEXT);
            fb.configLoadingImage(R.mipmap.ic_launcher);
            fb.configLoadfailImage(R.mipmap.ic_launcher);
        }
        return fb;
    }
}
