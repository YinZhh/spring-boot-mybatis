package com.example.reptile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.comp.Annotate;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;

/**
 * @ClassName AgentUse
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-27 10:00
 * @Version v.1.0.0
 */
public class AgentUse {


    public static void main(String[] args) {
        try {
            //获取代理ip
            //想要获取的代理IP个数，由需求方自行指定。（如果个数太多，将导致返回变慢）
            String ipresult = new ProxyCralwerUnusedVPN().startCrawler(1);
            if (ipresult != null && ipresult.trim().length() > 2) {
                String[] iphost = ipresult.split(",");
                System.out.println("获取IP------>" + iphost[0]);
                System.out.println("获取IP------>" + iphost[1]);
                // 如果不设置，只要代理IP和代理端口正确
                System.getProperties().setProperty("http.proxyHost", iphost[0]);
                System.getProperties().setProperty("http.proxyPort", iphost[1]);
            } else {
                // 如果不设置，只要代理IP和代理端口正确
                System.getProperties().setProperty("http.proxyHost", "58.252.6.165");
                System.getProperties().setProperty("http.proxyPort", "9000");
            }

            //获取地震数据
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String getbegin = "2017-04-25 01:00:00";
            String begin = getbegin.substring(0, 10);
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(getbegin));
            //设置当前日期
            c.add(Calendar.YEAR, 1); //间隔时间
            String end = sdf.format(c.getTime()).substring(0, 10);


            //获取地震历史数据 notification display sticky balloon
            //File type recognized: File extension *.dic was reassigned to Dictionary Revert


            //String url = "http://www.ceic.ac.cn/ajax/search?page=1&&start=" + begin + "&&end=" + end + "&&jingdu1=&&jingdu2=&&weidu1=&&weidu2=&&height1=&&height2=&&zhenji1=&&zhenji2=";
            //String url = "http://www.kugou.com/yy/html/rank.html";
            String url = "https://blog.csdn.net/";

            //String result = ProxyCralwerUnusedVPN.sendPost(url,"appid=2400&business=30032&_t=1522136902&sign: ca79064dee19a3befd2942f626dac205");
            String result = ProxyCralwerUnusedVPN.sendGet(url);

            System.out.println(result);
            if (!"".equals(result)) {
                String val = StringUtils.substringBeforeLast(result.substring(1), ")");

                System.out.println("val -=====>  "+val);

                JSONObject jsStr = JSONObject.parseObject(result);

                System.out.println("jsStr -=====>  "+jsStr);
                JSONArray shuju = jsStr.getJSONArray("shuju");

                Date oldhappenTime = sdf.parse(getbegin); //上次存储的最晚地震发生时刻
                Date newbeginTime = sdf.parse(getbegin); //记录新的最晚地震发生时刻（存到Redis中用于记录）
                for (int i = 0; i < shuju.size(); i++) {
                    JSONObject js = shuju.getJSONObject(i);
                    Date happenTime = sdf.parse(js.getString("O_TIME")); //地震发生时刻
                    String name = js.getString("LOCATION_C");//名称
                    if (happenTime.after(oldhappenTime)) {
                        System.out.println(sdf.format(happenTime) + "   " + name);
                        //记录新的最晚地震发生时刻（存到Redis中用于记录）
                        if (happenTime.after(newbeginTime)) {
                            newbeginTime = happenTime;//交换值
                        }
                    }
                }
                System.out.println("最晚地震时刻：" + sdf.format(newbeginTime));
                System.out.println(shuju.size());
                System.out.println(end);

            }

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}