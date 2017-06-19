package com.fancyedu.catesmart.utils;

import android.net.Uri;
import android.os.Environment;


import com.fancyedu.catesmart.common.Constant;

import java.io.File;
import java.io.IOException;

/**
 * Created by shuyu on 2016/11/15.
 * 文件管理
 */

public class FileUtils {
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();
    private static final String DATA_PATH = Environment.getDataDirectory().getPath();
    private static final String SD_STATE = Environment.getExternalStorageState();

    public static String getAppPath(String urlPath) {
        StringBuilder sb = new StringBuilder();
        if (SD_STATE.equals(
                Environment.MEDIA_MOUNTED)) {
            sb.append(SD_PATH);
        } else {
            sb.append(DATA_PATH);
        }
        sb.append(File.separator);
        sb.append(urlPath);
        return sb.toString();
    }

    // 获取录音存取的根目录
    public static String getRecorderAudioPath() {
        StringBuilder sb = new StringBuilder();
        if (SD_STATE.equals(
                Environment.MEDIA_MOUNTED)) {
            sb.append(SD_PATH);
        } else {
            sb.append(DATA_PATH);
        }
        sb.append(File.separator);
        sb.append(Constant.RECORDER_AUDIO_PATH);
        sb.append(File.separator);
        return sb.toString();
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                String[] filePaths = file.list();
                for (String path : filePaths) {
                    deleteFile(filePath + File.separator + path);
                }
                file.delete();
            }
        }
    }

    public static boolean creatFile(String urlPath) {
        urlPath = getAppPath(urlPath);
        File file = new File(urlPath);

        if (urlPath.endsWith(File.separator)) {
            //文件路径不能用文件夹路径格式
            return false;
        }
        //父目录是否存在
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            if (file.createNewFile()) {// 创建目标文件
                // 创建文件成功:";
                return true;
            } else {
                // "创建文件失败！
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean creatFileDir(String urlPath) {
        urlPath = getAppPath(urlPath);
        File dir = new File(urlPath);

        if (!urlPath.endsWith(File.separator)) {
            //路径必须为文件夹路径格式
            return false;
        }
        if (dir.mkdirs()) {
            return true;
        }
        return false;
    }

    // 创建目录
    public static boolean createDir(String destDirName) {
        destDirName = getAppPath(destDirName);
        File dir = new File(destDirName);
        if (dir.exists()) {// 判断目录是否存在
            System.out.println("创建目录失败，目标目录已存在！");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {// 创建目标目录
            System.out.println("创建目录成功！" + destDirName);
            return true;
        } else {
            System.out.println("创建目录失败！");
            return false;
        }
    }

    public static Uri getUri(String urlPath) {
        urlPath = getAppPath(urlPath);

        return Uri.parse(urlPath);
    }
}
