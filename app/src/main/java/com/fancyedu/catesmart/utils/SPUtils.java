package com.fancyedu.catesmart.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.fancyedu.catesmart.common.MyApplication;


public class  SPUtils {
    private final static String PREFERENCE_NAME = "fancy_flc";

    private static String isFirst_key = "isFirst";
    
    private static String isSearchRecord_key = "isSearchRecord";

    /**
     * 是否第一次安装
     *
     * @param value true 更新数据
     * @return
     */
    public static boolean first(boolean value) {
        SharedPreferences settings = MyApplication.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(isFirst_key, value);
        return editor.commit();
    }

    public static boolean isFirst() {
        SharedPreferences settings = MyApplication.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

        if (settings.getBoolean(isFirst_key, true)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 搜索记录
     *
     * @param value
     * @return
     */
    public static boolean putSearchRecord(String value) {
        SharedPreferences settings = MyApplication.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(isSearchRecord_key, value);
        return editor.commit();
    }

    /**
     * 获取搜索记录
     *
     * @return
     */
    public static String getSearchRecord() {
        SharedPreferences settings = MyApplication.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getString(isSearchRecord_key, "");
    }

} 