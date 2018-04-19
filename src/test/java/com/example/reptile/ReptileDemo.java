package com.example.reptile;


import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @ClassName ReptileDemo
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-23 14:42
 * @Version v.1.0.0
 */
public class ReptileDemo {
    /**
     * https://www.bilibili.com/
     *Mercedes-Benz
     * @Param args
     * @Throws Exception
     */
    public static void main(String[] args) throws Exception {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.bilibili.com/");

        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        //响应状态
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();

        String s = EntityUtils.toString(entity, Charset.defaultCharset());

        System.out.println(statusCode + "===========" + s);

        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            HeaderElement[] elements = header.getElements();
            for (HeaderElement element : elements) {
                System.out.println(element.toString());
            }
        }
        response.close();
        closeableHttpClient.close();
    }

    public void post() throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        closeableHttpClient.execute(new HttpGet());
        HttpPost httpPost = new HttpPost("https://www.bilibili.com/");

        RequestConfig.Builder builder = RequestConfig.custom().setProxy(new HttpHost("192.168.0.1", 9527));
        builder.setAuthenticationEnabled(true);

        httpPost.setConfig(builder.build());
    }
}
