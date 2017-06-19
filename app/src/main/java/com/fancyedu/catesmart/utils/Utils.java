package com.fancyedu.catesmart.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.fancyedu.catesmart.common.MyApplication;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Hyy on 2016/12/21.
 */

public class Utils {
    private static float mDensity = DisplayMetrics.DENSITY_DEFAULT;

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = MyApplication.context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = MyApplication.context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int dip2pix(Context context, int dip) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return (int) (dm.density * (float) dip);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

//    //  jason串转带泛型的bean类 。
//    public static <T> BaseBean<T> fromJsonObject(String reader, Class<T> clazz) {
//        Type type = new ParameterizedTypeImpl(BaseBean.class, new Class[]{clazz});
//        return new Gson().fromJson(reader, type);
//    }


    public static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] args;

        public ParameterizedTypeImpl(Class raw, Type[] args) {
            this.raw = raw;
            this.args = args != null ? args : new Type[0];
        }

        @Override
        public Type[] getActualTypeArguments() {
            return args;
        }

        @Override
        public Type getRawType() {
            return raw;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

    //获取本地文件夹中的音频

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else return mobiles.matches(telRegex);
    }


    public static int getScreeWidth() {
        WindowManager wm = (WindowManager) MyApplication.context
                .getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getWidth();
    }

    public static int getScreeHeight() {
        WindowManager wm = (WindowManager) MyApplication.context
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    /**
     * 获取版本名称
     *
     * @return 当前应用的版本名称
     */
    public static String getVersionName() {
        try {
            PackageManager manager = MyApplication.context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(MyApplication.context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.00";
        }
    }


    /**
     * 获取版本号
     *
     * @return 当前应用的更新次数
     */
    public static int getVersionCode() {
        try {
            PackageManager manager = MyApplication.context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(MyApplication.context.getPackageName(), 0);
            int version = info.versionCode;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static String getPicPath(String picPath, int width, int hight) {
        return picPath + "?x-oss-process=image/resize,m_fill,w_" + width + ",h_" + hight + ",limit_0/auto-orient,0/format,png";
    }
}
