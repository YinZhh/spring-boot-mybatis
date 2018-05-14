package com.example.imagetextrecognition;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AuthService 图片文字识别
 * @Description That's the purpose of the class 获取access_token类
 * @Author yin.zhh
 * @Date 2018-04-20 15:59
 * @Version v.1.0.0
 */
public class AuthService {

    private static final String AuthHost = "https://aip.baidubce.com/oauth/2.0/token?";
    private static final String AK = "zqbh54gBK8hsFxlQAZK8ShKe";// 官网获取的 API Key 更新为你注册的
    private static final String SK = "l3TBGTQ7EarjDVDKYem1u39Ny5faM0lf";// 官网获取的 Secret Key 更新为你注册的

    /**
     * @Description (That's the purpose of the method)  获取access_token
     * @Date 2018/4/20 17:54
     * @Param []
     * @Return java.lang.String
     * @Throws
     */
    static String getAuth() {
        return getAuthToken();
    }

    /**
     * @Description (That's the purpose of the method) 获取API访问access_token,有效期为30天，需要每30天进行定期更换
     * @Date 2018/4/20 16:00
     * @Param ak - 百度云官网获取的 API Key
     * @Param sk - 百度云官网获取的 Securet Key
     * @Return java.lang.String 示例："24.c7a14699ad82424048ae13d00a83d513.2592000.1527042588.282335-11132855"
     * @Throws
     */
    private static String getAuthToken() {
        // 获取token地址
        String getAccessTokenUrl = AuthHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + AK
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + SK;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            //返回结果示例
            System.out.println("result:" + result);
            JSONObject jsonObject = new JSONObject(JSONObject.parseObject(result.toString()));
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            System.err.print("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getAuth());
    }
}
