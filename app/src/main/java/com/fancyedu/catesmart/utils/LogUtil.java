package com.fancyedu.catesmart.utils;

import android.util.Log;


/**
 * Created by Hyy on 2016/9/22.
 */
public class LogUtil {

    public static void MyLog(String log, String msg) {
        if (true) {
            msg = msg.trim();
            int index = 0;
            int maxLength = 100000;
            String sub;
            while (index < msg.length()) {
                // java的字符不允许指定超过总的长度end
                if (msg.length() <= index + maxLength) {
                    sub = msg.substring(index);
                } else {
                    sub = msg.substring(index, maxLength);
                }

                index += maxLength;
                Log.i(log, sub.trim());
            }
//            Log.i(log, msg);
        }
    }
}
