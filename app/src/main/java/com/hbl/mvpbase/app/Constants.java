package com.hbl.mvpbase.app;

import android.os.Environment;

import java.io.File;

public class Constants {

    //================= TYPE ====================
    public static final int TYPE_ANDROID = 102;
    public static final int TYPE_IOS = 103;
    public static final int TYPE_WEB = 104;

    //================= KEY ====================
    public static final String KEY_API = "52b7ec3471ac3bec6846577e79f20e4c"; //需要APIKEY请去 http://www.tianapi.com/#wxnew 申请,复用会减少访问可用次数
    public static final String BUGLY_ID = "257700f3f8";
    //================= PATH ====================
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";


}
