package com.example.count;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @ClassName countDemo
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-22 13:18
 * @Version v.1.0.0
 */
public class countDemo {

    public static void main(String[] args) {
//        demo01();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("G:\\PDF\\深入理解Java虚拟机.pdf"))));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void demo01() {
        InputStream inputStream = null;
        ByteOutputStream baos = null;
        try {
            inputStream = new FileInputStream(new File("G:\\PDF\\深入理解Java虚拟机.pdf"));
            baos = new ByteOutputStream();
            byte[] arr = new byte[1024 * 8];

            int len;
            while ((len = inputStream.read(arr)) != -1) {
                baos.write(arr, 0, len);
                baos.flush();
            }

            String s = baos.toString();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (baos != null) {
                baos.close();
            }
        }
    }
}
