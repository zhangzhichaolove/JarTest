package com.test.chao.jartest.utils;

import android.os.Environment;

import java.io.File;

/**
 * Description: Constants
 */
public class Constants {
    //================= PATH ====================
    //public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = Environment.getExternalStorageDirectory() + File.separator + "JarCache";

}