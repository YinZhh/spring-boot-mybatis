package com.example.imagetextrecognition;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName Check 图像文字识别
 * @Description That's the purpose of the class 参考文档: https://cloud.baidu.com/ 和 http://ai.baidu.com/docs#/OCR-API/top
 * @Author yin.zhh
 * @Date 2018-04-20 16:07
 * @Version v.1.0.0
 */
public class Check {
    private static final String POST_URL = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic?access_token=" + "24.c7a14699ad82424048ae13d00a83d513.2592000.1527042588.282335-11132855";// + AuthService.getAuth();

    /**
     * @Description (That's the purpose of the method) 识别本地图片的文字
     * @Date 2018/4/20 16:08
     * @Param [path] 本地图片地址
     * @Return java.lang.String 识别结果，为json格式
     * @Throws URISyntaxException URI打开异常 IOException io流异常
     */
    private static String checkFile(String path) throws URISyntaxException, IOException {

        File file = new File(path);

        if (!file.exists()) {
            throw new NullPointerException("图片不存在");
        }
        return post("image=" + BaseImg64.getImageStrFromPath(path));
    }

    /**
     * @Description (That's the purpose of the method)
     * @Date 2018/4/20 16:12
     * @Param [url] 图片url
     * @Return java.lang.String 识别结果，为json格式
     * @Throws
     */
    private static String checkUrl(String url) throws IOException, URISyntaxException {
        return post("url=" + url);
    }

    /**
     * @Description (That's the purpose of the method) 通过传递参数：url和image进行文字识别
     * @Date 2018/4/20 16:13
     * @Param [param] 区分是url还是image识别
     * @Return java.lang.String 识别结果
     * @Throws URISyntaxException URI打开异常
     * @Throws IOException IO流异常
     */
    private static String post(String param) throws URISyntaxException, IOException {

        //开始搭建post请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost();
        URI url = new URI(POST_URL);
        post.setURI(url);
        //设置请求头，请求头必须为application/x-www-form-urlencoded，因为是传递一个很长的字符串，不能分段发送
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        StringEntity entity = new StringEntity(param);
        post.setEntity(entity);
        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                /*读取服务器返回过来的json字符串数据*/
                return EntityUtils.toString(response.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private static void conversionString(String s) {
        JSONObject jsonObject = JSON.parseObject(s);

        System.out.println(jsonObject.toJSONString());
        JSONArray jsonArray = jsonObject.getJSONArray("words_result");
        StringBuilder sb = new StringBuilder();
        for (Object o : jsonArray) {
            JSONObject parseObject = JSON.parseObject(o.toString());
            sb.append(parseObject.get("words"));
        }
        System.out.println(sb);
        /*try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("SQL优化.txt")));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        //String path = "G:\\PDF\\追风筝的人.jpg";
        String path = "G:\\PDF\\sql优化.png";
        try {
            //long now = System.currentTimeMillis();
            String s = checkFile(path);
            conversionString(s);
            //System.out.println(s);
            //String s1 = checkUrl("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=08c05c0e8444ebf8797c6c6db890bc4f/fc1f4134970a304e46bfc5f7d2c8a786c9175c19.jpg");
            //System.out.println("耗时：" + (System.currentTimeMillis() - now) / 1000 + "s" + s1);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
