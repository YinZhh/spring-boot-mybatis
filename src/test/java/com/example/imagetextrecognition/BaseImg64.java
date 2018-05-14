package com.example.imagetextrecognition;

import com.example.boot.utils.FileUtil;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @ClassName BaseImg64
 * @Description That's the purpose of the class 图片转化base64后再UrlEncode结果
 * @Author yin.zhh
 * @Date 2018-04-20 16:05
 * @Version v.1.0.0
 */
class BaseImg64 {
    /**
     * @Description (That ' s the purpose of the method) 将一张本地图片转化成Base64字符串
     * @Date 2018/4/20 16:06
     * @Param [imgPath] imgPath 本地图片地址
     * @Return java.lang.String 图片转化base64后再UrlEncode结果
     * @Throws
     */
    static String getImageStrFromPath(String imgPath) {
        InputStream in;
        byte[] data;
        // 读取图片字节数组
        try {
            byte[] imgData = FileUtil.readFileByBytes(imgPath);
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            // 对字节数组Base64编码
            // 返回Base64编码过再URLEncode的字节数组字符串
            in.close();
            return URLEncoder.encode(new BASE64Encoder().encode(data),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
