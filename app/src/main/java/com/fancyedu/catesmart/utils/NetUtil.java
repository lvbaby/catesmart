package com.fancyedu.catesmart.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Hyy on 2016/9/22.
 */
public class NetUtil {

    /**
     * 检测网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }

        return false;
    }

    //获取网络返回结果
    public static String getResResult(Response<ResponseBody> responseBodyResponse) {
        String result = "";
        try {
            if (responseBodyResponse.body() != null) {
                result = responseBodyResponse.body().string();
                LogUtil.MyLog("responseBodyResponse", "返回数据============" + result);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.MyLog("responseBodyResponse", "======IOException=======" + e);
            return result;
        }
        LogUtil.MyLog("responseBodyResponse", "返回数据为空：" + result);
        return result;
    }
}
