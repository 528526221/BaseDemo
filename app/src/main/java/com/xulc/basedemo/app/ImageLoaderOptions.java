package com.xulc.basedemo.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;


import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xulc.basedemo.R;


import java.io.File;

/**
 * Created by xuliangchun on 2016/7/8.
 * ImageLoader初始化配置
 */
public class ImageLoaderOptions {

    public static void config(Context context)
    {
        //创建默认的ImageLoader配置参数
        //ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
            .memoryCacheExtraOptions(480, 800)
            // max width, max height，即保存的每个缓存文件的最大长宽
            .discCacheExtraOptions(480, 800, null)
                    // Can slow ImageLoader, use it carefully (Better don't use
                    // it)/设置缓存的详细信息，最好不要设置这个
            .threadPoolSize(3)
                    // 线程池内加载的数量
            .threadPriority(Thread.NORM_PRIORITY - 2)
            .denyCacheImageMultipleSizesInMemory()
            .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                    // You can pass your own memory cache
                    // implementation/你可以通过自己的内存缓存实现
            .memoryCacheSize(2 * 1024 * 1024)
            .discCacheSize(50 * 1024 * 1024)
            .discCacheFileNameGenerator(new Md5FileNameGenerator())
                    // 将保存的时候的URI名称用MD5 加密
            .tasksProcessingOrder(QueueProcessingType.LIFO)
            .discCacheFileCount(100)// 缓存的文件数量
            .discCache(new UnlimitedDiskCache(new File(Environment.getExternalStorageDirectory()
                                                   + "/cowry/imgCache")))
                    // 自定义缓存路径
            .defaultDisplayImageOptions(options)
            .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
            .writeDebugLogs() // Remove for release app
            .build();// 开始构建
        ImageLoader.getInstance().init(configuration);
    }

    public static DisplayImageOptions options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
        .showImageForEmptyUri(R.mipmap.ic_launcher) // resource or drawable
        .showImageOnFail(R.mipmap.ic_launcher) // resource or drawable
        .considerExifParams(false) // default
        .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
        .bitmapConfig(Bitmap.Config.ARGB_8888) // default
        .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
        .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
        .displayer(new SimpleBitmapDisplayer()) // default
        .handler(new Handler()) // default
        .build();
}
