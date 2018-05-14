package com.example.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName ImageDeal 图像处理类(旋转 缩放 马赛克).
 * @Description That's the purpose of the class 图片马赛克
 * @Author yin.zhh
 * @Date 2018-04-26 10:37
 * @Version v.1.0.0
 */
public class PictureMosaic {
    private String openUrl; // 原始图片打开路径
    private String saveUrl; // 新图保存路径
    private String saveName; // 新图名称
    private String suffix; // 新图类型 只支持gif,jpg,png

    public PictureMosaic(String openUrl, String saveUrl, String saveName, String suffix) {
        this.openUrl = openUrl;
        this.saveName = saveName;
        this.saveUrl = saveUrl;
        this.suffix = suffix;
    }

    /**
     * @Description (That ' s the purpose of the method)  图片缩放.
     * @Date 2018/4/26 10:38
     * @Param [width 需要的宽度, height 需要的高度]
     * @Return void
     * @Throws
     */
    public void zoom(int width, int height) throws Exception {

        double sx;
        double sy;

        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        // 计算x轴y轴缩放比例--如需等比例缩放，在调用之前确保参数width和height是等比例变化的
        sx = (double) width / bi.getWidth();
        sy = (double) height / bi.getHeight();

        AffineTransformOp op = new AffineTransformOp(
                AffineTransform.getScaleInstance(sx, sy), null);
        File sf = new File(saveUrl, saveName + "." + suffix);
        Image zoomImage = op.filter(bi, null);
        try {
            ImageIO.write((BufferedImage) zoomImage, suffix, sf); // 保存图片
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description (That ' s the purpose of the method)  旋转
     * @Date 2018/4/26 10:39
     * @Param [degree 旋转角度]
     * @Return void
     * @Throws
     */
    public void spin(int degree) throws Exception {

        int swidth = 0; // 旋转后的宽度
        int sheight = 0; // 旋转后的高度
        int x; // 原点横坐标
        int y; // 原点纵坐标

        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        // 处理角度--确定旋转弧度
        degree = degree % 360;
        if (degree < 0)
            degree = 360 + degree;// 将角度转换到0-360度之间
        double theta = Math.toRadians(degree);// 将角度转为弧度

        // 确定旋转后的宽和高
        if (degree == 180 || degree == 0 || degree == 360) {
            swidth = bi.getWidth();
            sheight = bi.getHeight();
        } else if (degree == 90 || degree == 270) {
            sheight = bi.getWidth();
            swidth = bi.getHeight();
        } else {
            swidth = (int) (Math.sqrt(bi.getWidth() * bi.getWidth() + bi.getHeight() * bi.getHeight()));
            sheight = (int) (Math.sqrt(bi.getWidth() * bi.getWidth() + bi.getHeight() * bi.getHeight()));
        }

        x = (swidth / 2) - (bi.getWidth() / 2);// 确定原点坐标
        y = (sheight / 2) - (bi.getHeight() / 2);

        BufferedImage spinImage = new BufferedImage(swidth, sheight, bi.getType());
        // 设置图片背景颜色
        Graphics2D gs = (Graphics2D) spinImage.getGraphics();
        gs.setColor(Color.white);
        gs.fillRect(0, 0, swidth, sheight);// 以给定颜色绘制旋转后图片的背景

        AffineTransform at = new AffineTransform();
        at.rotate(theta, swidth / 2, sheight / 2);// 旋转图象
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        spinImage = op.filter(bi, spinImage);
        File sf = new File(saveUrl, saveName + "." + suffix);
        ImageIO.write(spinImage, suffix, sf); // 保存图片

    }

    /**
     * @Description (That ' s the purpose of the method)  马赛克化.
     * @Date 2018/4/26 10:40
     * @Param [size] 马赛克尺寸，即每个矩形的长宽
     * @Return boolean
     * @Throws
     */
    public boolean mosaic(int size) throws Exception {
        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        BufferedImage spinImage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        if (bi.getWidth() < size || bi.getHeight() < size || size <= 0) { // 马赛克格尺寸太大或太小
            return false;
        }

        int xcount = 0; // x方向绘制个数
        int ycount = 0; // y方向绘制个数
        if (bi.getWidth() % size == 0) {
            xcount = bi.getWidth() / size;
        } else {
            xcount = bi.getWidth() / size + 1;
        }
        if (bi.getHeight() % size == 0) {
            ycount = bi.getHeight() / size;
        } else {
            ycount = bi.getHeight() / size + 1;
        }
        int x = 0;   //坐标
        int y = 0;
        // 绘制马赛克(绘制矩形并填充颜色)
        Graphics gs = spinImage.getGraphics();
        for (int i = 0; i < xcount; i++) {
            for (int j = 0; j < ycount; j++) {
                //马赛克矩形格大小
                int mwidth = size;
                int mheight = size;
                if (i == xcount - 1) {   //横向最后一个比较特殊，可能不够一个size
                    mwidth = bi.getWidth() - x;
                }
                if (j == ycount - 1) {  //同理
                    mheight = bi.getHeight() - y;
                }
                // 矩形颜色取中心像素点RGB值
                int centerX = x;
                int centerY = y;
                if (mwidth % 2 == 0) {
                    centerX += mwidth / 2;
                } else {
                    centerX += (mwidth - 1) / 2;
                }
                if (mheight % 2 == 0) {
                    centerY += mheight / 2;
                } else {
                    centerY += (mheight - 1) / 2;
                }
                Color color = new Color(bi.getRGB(centerX, centerY));
                gs.setColor(color);
                gs.fillRect(x, y, mwidth, mheight);
                y = y + size;// 计算下一个矩形的y坐标
            }
            y = 0;// 还原y坐标
            x = x + size;// 计算x坐标
        }
        gs.dispose();
        File sf = new File(saveUrl, saveName + "." + suffix);
        ImageIO.write(spinImage, suffix, sf); // 保存图片
        return true;
    }

    /**--------------------------------------------------------*/


    /**
     * 给图片不同位置添加多个图片水印、可设置水印图片旋转角度
     *
     * @param icon      水印图片路径（如：F:/images/icon.png）
     * @param source    没有加水印的图片路径（如：F:/images/6.jpg）
     * @param output    加水印后的图片路径（如：F:/images/）
     * @param imageName 图片名称（如：11111）
     * @param imageType 图片类型（如：jpg）
     * @param degree    水印图片旋转角度，为null表示不旋转
     */
    public static String markImageByMoreIcon(String icon, String source, String output, String imageName, String imageType, Integer degree) {
        String result = "添加图片水印出错";
        try {
            File file = new File(source);
            File ficon = new File(icon);
            if (!file.isFile()) {
                return source + " 不是一个图片文件!";
            }
            //将icon加载到内存中
            Image ic = ImageIO.read(ficon);
            //icon高度
            int icheight = ic.getHeight(null);

            //将源图片读到内存中
            Image img = ImageIO.read(file);
            //图片宽
            int width = img.getWidth(null);
            //图片高
            int height = img.getHeight(null);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //创建一个指定 BufferedImage 的 Graphics2D 对象
            Graphics2D g = bi.createGraphics();
            //x,y轴默认是从0坐标开始
            int x = 0;
            int y = 0;
            //默认两张水印图片的间隔高度是水印图片的1/3
            int temp = icheight / 3;
            int space = 1;
            if (height >= icheight) {
                space = height / icheight;
                if (space >= 2) {
                    temp = y = icheight / 2;
                }
            } else {
                x = 0;
                y = 0;
            }
            //设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            //呈现一个图像，在绘制前进行从图像空间到用户空间的转换
            g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            for (int i = 0; i < space; i++) {
                if (null != degree) {
                    //设置水印旋转
                    g.rotate(Math.toRadians(degree), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
                }
                //水印图象的路径 水印一般为gif或者png的，这样可设置透明度
                ImageIcon imgIcon = new ImageIcon(icon);

                //得到Image对象。
                Image con = imgIcon.getImage();
                //透明度，最小值为0，最大值为1
                float clarity = 0.6f;
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));

                //表示水印图片的坐标位置(x,y)
                //g.drawImage(con, 300, 220, null);
                g.drawImage(con, x, y, null);
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
                y += (icheight + temp);
            }
            g.dispose();
            File sf = new File(output, imageName + "." + imageType);
            ImageIO.write(bi, imageType, sf); // 保存图片
            result = "图片完成添加Icon水印";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 给图片添加单个图片水印、可设置水印图片旋转角度
     *
     * @param icon      水印图片路径（如：F:/images/icon.png）
     * @param source    没有加水印的图片路径（如：F:/images/6.jpg）
     * @param output    加水印后的图片路径（如：F:/images/）
     * @param imageName 图片名称（如：11111）
     * @param imageType 图片类型（如：jpg）
     * @param degree    水印图片旋转角度，为null表示不旋转
     */
    public static String markImageBySingleIcon(String icon, String source, String output, String imageName, String imageType, Integer degree) {
        String result = "添加图片水印出错";
        try {
            File file = new File(source);
            File ficon = new File(icon);
            if (!file.isFile()) {
                return source + " 不是一个图片文件!";
            }
            //将icon加载到内存中
            Image ic = ImageIO.read(ficon);
            //icon高度
            int icheight = ic.getHeight(null);

            //将源图片读到内存中
            Image img = ImageIO.read(file);
            //图片宽
            int width = img.getWidth(null);
            //图片高
            int height = img.getHeight(null);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //创建一个指定 BufferedImage 的 Graphics2D 对象
            Graphics2D g = bi.createGraphics();
            //x,y轴默认是从0坐标开始
            int x = 0;
            int y = (height / 2) - (icheight / 2);
            //设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            //呈现一个图像，在绘制前进行从图像空间到用户空间的转换
            g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                //设置水印旋转
                g.rotate(Math.toRadians(degree), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
            }
            //水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(icon);

            //得到Image对象。
            Image con = imgIcon.getImage();
            //透明度，最小值为0，最大值为1
            float clarity = 0.6f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));

            //表示水印图片的坐标位置(x,y)
            //g.drawImage(con, 300, 220, null);
            g.drawImage(con, x, y, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            g.dispose();
            File sf = new File(output, imageName + "." + imageType);
            ImageIO.write(bi, imageType, sf); // 保存图片
            result = "图片完成添加Icon水印";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 给图片添加多个文字水印、可设置水印文字旋转角度
     *
     * @param source    需要添加水印的图片路径（如：F:/images/6.jpg）
     * @param output    添加水印后图片输出路径（如：F:/images/）
     * @param imageName 图片名称（如：11111）
     * @param imageType 图片类型（如：jpg）
     * @param color     水印文字的颜色
     * @param word      水印文字
     * @param degree    水印文字旋转角度，为null表示不旋转
     */
    public static String markImageByMoreText(String source, String output, String imageName, String imageType, Color color, String word, Integer degree) {
        String result = "添加文字水印出错";
        try {
            //读取原图片信息
            File file = new File(source);
            if (!file.isFile()) {
                return file + " 不是一个图片文件!";
            }
            Image img = ImageIO.read(file);
            //图片宽
            int width = img.getWidth(null);
            //图片高
            int height = img.getHeight(null);
            //文字大小
            int size = 50;
            //加水印
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            g.drawImage(img, 0, 0, width, height, null);
            //设置水印字体样式
            Font font = new Font("宋体", Font.PLAIN, size);
            //根据图片的背景设置水印颜色
            g.setColor(color);
            int x = width / 3;
            int y = size;
            int space = height / size;
            for (int i = 0; i < space; i++) {
                //如果最后一个坐标的y轴比height高，直接退出
                if ((y + size) > height) {
                    break;
                }
                if (null != degree) {
                    //设置水印旋转
                    g.rotate(Math.toRadians(degree), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
                }
                g.setFont(font);
                //水印位置
                g.drawString(word, x, y);
                y += (2 * size);
            }
            g.dispose();
            //输出图片
            File sf = new File(output, imageName + "." + imageType);
            ImageIO.write(bi, imageType, sf); // 保存图片
            result = "图片完成添加Word水印";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 给图片添加单个文字水印、可设置水印文字旋转角度
     *
     * @param color     水印文字的颜色
     * @param word      水印文字
     * @param degree    水印文字旋转角度，为null表示不旋转
     * @param typeface  字体 例:"宋体"
     */
    public String markImageBySingleText(Color color, String word, Integer degree,String typeface) {

        String result = "添加文字水印出错";
        try {
            //读取原图片信息
            File file = new File(openUrl);
            if (!file.isFile()) {
                return file + " 不是一个图片文件!";
            }
            Image img = ImageIO.read(file);
            int width = img.getWidth(null);
            int height = img.getHeight(null);
            //加水印
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            g.drawImage(img, 0, 0, width, height, null);
            //设置水印字体样式
            Font font = new Font(typeface, Font.PLAIN, 50);
            //根据图片的背景设置水印颜色
            g.setColor(color);
            if (null != degree) {
                //设置水印旋转
                g.rotate(Math.toRadians(degree), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
            }
            g.setFont(font);
            int x = width / 20;//数字越大越往左上角
            int y = height / 2;
            //水印位置
            g.drawString(word, x, y);
            g.dispose();
            //输出图片
            File sf = new File(saveUrl, saveName + "." + suffix);
            ImageIO.write(bi, suffix, sf); // 保存图片
            result = "图片完成添加Word水印";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        PictureMosaic imageDeal = new PictureMosaic("G:\\tx\\backgroundImage\\FD~]`H9)8T%$%7[9Y(]GO}4.jpg", "e:\\", "2", "jpg");
        // 测试缩放
        /*imageDeal.zoom(200, 300);*/
        // 测试旋转
        /*imageDeal.spin(90);*/
        //测试马赛克
        /*imageDeal.mosaic(4);*/
        //测试水印
        imageDeal.markImageBySingleText(Color.RED,"欢迎使用图片水印功能",40,"华文行楷");
    }

}
