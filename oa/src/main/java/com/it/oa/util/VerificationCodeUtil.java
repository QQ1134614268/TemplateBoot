package com.it.oa.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerificationCodeUtil {

    private static final int width = 100;// 生成验证码图片的宽度
    private static final int height = width / 5 * 2;// 生成验证码图片的高度
    private static final String[] fontNames = {"宋体", "楷体", "隶书", "微软雅黑"};
    private static final Random random = new Random();

    /**
     * 获取一个随意颜色
     */
    private static Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 获取一个随机字体
     */
    private static Font randomFont() {
        String name = fontNames[random.nextInt(fontNames.length)];
        int style = random.nextInt(4);
        // private static int[]   styles = {Font.BOLD,Font.ITALIC,Font.PLAIN};
        // int style = styles[random.nextInt(4)];
        int size = random.nextInt(5) + 24;
        return new Font(name, style, size);
    }

    /**
     * 获取一个随机字符
     */
    public static String randomText() {
        return StringUtil.randomText(4);
    }


    public static BufferedImage getImage(String text) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.setBackground(new Color(255, 255, 255));// 定义验证码图片的背景颜色为白色
        // 绘制矩形背景
        g2.fillRect(0, 0, width, height);
        drawText(image, text);
        drawLine(image);
        return image;
    }


    private static void drawText(BufferedImage image, String text) {
        Graphics2D g2 = image.createGraphics();
        g2.setColor(randomColor());
        g2.setFont(randomFont());
        float size = width * 1f / (text.length() + 1);
        float point_x = size / 2;
        float point_y = size * 1.5f;
        g2.drawString(text, point_x, point_y);
    }


    /**
     * 绘制干扰线
     */
    private static void drawLine(BufferedImage image) {
        Graphics2D g2 = image.createGraphics();
        int num = 5;
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setColor(randomColor());
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}