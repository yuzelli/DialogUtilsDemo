package com.example.yuzelli.dialogutilsdemo;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by 51644 on 2017/7/20.
 */

public class appliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .writeDebugLogs() // Remove for release app
                .memoryCacheExtraOptions(400, 400) // default = device screen dimensions
                .memoryCache(new WeakMemoryCache())
                .threadPoolSize(3) // default
                .build();

        ImageLoader.getInstance().init(config);
    }
}
