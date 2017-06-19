package com.fancyedu.catesmart.common;

/**
 * Created by Hyy on 2016/9/22.
 */
public class Constant {

    //    public static String BASE_URL = "http://192.168.1.40:8080/";
    public static String BASE_URL = "http://www.ngkidschina.cn/";   //android正式
    //    public static String BASE_URL = "http://daily.m.ngkidschina.cn/";   //android测试地址

    public static String MALL_SERVICE_URL = "http://mall.fancyedu.com/"; //商城服务端地址
    //    public static String MALL_SERVICE_URL = "http://daily.mall.fancyedu.com/"; //商城服务端地址
    //    public static String MALL_SERVICE_URL = "http://192.168.1.17:8080/"; //商城服务端地址

    public static final String ERROR_LOGIN_CODE = "405";

    // APP_ID 替换为你的应用从官方网站申请到的合法appId
    public static final String APP_ID = "wx76e6c09183a2cb44";

    public static boolean release = false;

    public final static String WXPAY_CALLBACK_NAME = "WX_PAY";  //广播名称

    public final static String WXPAY_RESULT = "WX_PAY_RESULT";  //广播名称

    public final static String NET_ERROR = "请保持网络通畅";    //访问网络失败

    public static final String RECORDER_AUDIO_PATH = "Fancy/learnceter/audio"; //录音路径
    // 文件父文件夹
    public static final String APP_FILE_PATH = "Fancy/learnceter/";
    //头像裁切目录
    public static final String HEADER_CUT_PATH = "Fancy/learnceter/imgs/";

    public static final String SIGN_NAME_HEADER = "sign";

    public final static int FRESH_CALLBACK = 1000;
    public final static int FRESH_RESULT_CALLBACK = 1000;
    public final static long TABLEID = 100;  //插入表中语音数据的写死id

    public static String loginToken = "";
    public static String JSESSIONID = "";

    //RSA公钥
    public static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCijHSxvcw6d2IonSz7tXDnqvnNAaCFOob74toEqoFggqVyBLMhtsPty6Ki1TbIdkVxwRHHYbd46BEbcPcl6tvPfCFUEZeBZqy8+JAJiZc9MkVX0qKnfvf6KeQBuMifkJYqM84Ndwqlcw8UVkHmH4qlhZYGd07GfmqaBEAmhOyPsQIDAQAB";
    public static final String showResourceCoverImg = "showResourceCoverImg";
    public static final String showResourceId = "showResourceId";
    public static final String playLink = "playLink";
    public static final String showResourceName = "showResourceName";
    public static final String intro = "intro";


    public static Boolean isBind = true;

    public static String schoolName;

    public static String schoolID;

    public final static String KEY_FR0M = "flc";

    public static Boolean isLogin = false;

    //商城接口（我的活动）
    public static String getMallActivity() {
        return MALL_SERVICE_URL + "activity/myActivity.html";
    }

    //商城接口（登录接口）
    public static String getMallLoginUrl() {
        return MALL_SERVICE_URL + "app/login.html?keyFrom=" + KEY_FR0M;
    }

    //商城接口（退出登录接口）
    public static String getMallLoginOutUrl() {
//        http://mall.fancyedu.com/customer/customerMsg.html
        return MALL_SERVICE_URL + "/logout.do";
    }


    //商城接口（搜索接口）
    public static String getSearchUrl(String search) {
        return MALL_SERVICE_URL + " /goods/list.html?keyFrom=" + KEY_FR0M + "&goodsName=" + search;
    }


    public static String getMallShopCart() {
        return MALL_SERVICE_URL + "cart/shoppingCart.html";
    }

    //商城接口（课程详情）
    public static String getCourseDetail(String lessonDetailId, String schoolId) {
        return MALL_SERVICE_URL + "rct/lessonSignup?lessonDetailId=" + lessonDetailId + "&schoolId=" + schoolId;
    }

    //商城接口（我的订单）
    public static String getMallOrder() {
        return MALL_SERVICE_URL + "/order/myOrder.html";
    }

    //商城接口（获取商城链接）
    public static String getMallUrl(String linkUrl) {
        return MALL_SERVICE_URL + linkUrl;
    }


    //商城接口（我的红包）
    public static String getMallRedPacket() {
        return MALL_SERVICE_URL + "customer/myWallets.html";
    }

    //商城接口（我的课程）
    public static String getMyLesson() {
        return MALL_SERVICE_URL + "rct/myLesson";
    }


    //商城接口（我的课程）
    public static String getISBNBook(String isbn) {
        return MALL_SERVICE_URL + "goods/isbndetail.html?isbn=" + isbn;
    }
}
