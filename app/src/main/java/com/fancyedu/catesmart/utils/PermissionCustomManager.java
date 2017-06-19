package com.fancyedu.catesmart.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


/**
 * Created by shiweiwei on 2016/5/25.
 */
public class PermissionCustomManager {

    private OnPermissionListener listener;
    private Activity context;

    public interface OnPermissionListener {
        public void onAccept();
    }
    public PermissionCustomManager(Activity context, String type, OnPermissionListener listener) {
        this.context = context;
        this.listener = listener;
        start(type);
    }

    private void start(String type) {
        if (ContextCompat.checkSelfPermission(context,
                type)
                != PackageManager.PERMISSION_GRANTED) {
            //进行权限请求
            ActivityCompat.requestPermissions(context,
                    new String[]{type},
                    200);

        } else if (listener != null) {
            listener.onAccept();
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 200:
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        listener.onAccept();
                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setMessage("请允许权限，不然无法访问成功")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    }).create().show();

                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setMessage("请在设置中打开权限，不然无法访问成功")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    }).create().show();
                        }
                    }
                }


                break;

        }
    }

}
