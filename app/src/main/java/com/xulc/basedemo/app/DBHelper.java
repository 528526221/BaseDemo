package com.xulc.basedemo.app;

import android.content.Context;

import net.tsz.afinal.FinalDb;

/**
 * Created by xuliangchun on 2016/7/8.
 */
public class DBHelper {
    private static FinalDb db;
    private static Context APPLICATION_CONTEXT;


    public static void init(Context context) {
        APPLICATION_CONTEXT = context;
    }
    public static FinalDb getInstance() {
        if (db == null) {
            db = FinalDb.create(APPLICATION_CONTEXT);
        }
        return db;
    }
}
