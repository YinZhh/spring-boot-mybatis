package com.example.count;


import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName ReadPdf
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-22 14:08
 * @Version v.1.0.0
 */
public class ReadPdf {
    public static void main(String[] args) throws Exception {
        String path = "G:\\PDF\\阿里巴巴Java开发手册v1.2.0.pdf";
        //String pdf = getTextFromPDF(path);
        String pdf = getTextFromPdf(path);
        int count = 0;
        String[] arr = pdf.split(" ");
        for (String s : arr) {
            if (s.contains("...................") || s.equals("")) {
                continue;
            }
            count += s.length();
        }
        System.out.println(pdf);
        System.out.println(count);
        // getXPDF(path);
    }

    private static String getTextFromPDF(String pdfFilePath) {
        String result = null;
        PDDocument document = null;
        try {
            PDFParser parser = new PDFParser(new FileInputStream(pdfFilePath));
            parser.parse();
            document = parser.getPDDocument();
            result = new PDFTextStripper().getText(document);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * @Description (That ' s the purpose of the method)  读出的pdf的内容
     * @Date 2018/3/22 15:55
     * @Param [filePath]
     * @Return java.lang.String
     * @Throws
     */
    private static String getTextFromPdf(String filePath) {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(filePath);
            PDFParser parser = new PDFParser(is);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
