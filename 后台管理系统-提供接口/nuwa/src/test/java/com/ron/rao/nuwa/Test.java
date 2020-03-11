package com.ron.rao.nuwa;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author huang(jy)
 * @Date 2019/3/12 14:04
 */
public class Test {
    public static Font font;
    public static void main(String[] args) throws Exception {

        CyFont cf=new CyFont();
        font = cf.getDefinedFont("F:\\Downloads\\字魂100号-方方先锋体\\font.ttf", 80);
        createImage("Tissot机械表",font,new File("e:/a.png"),480,150);
//        createImage("SKG按摩仪",font,new File("e:/b.png"),480,150);
//        createImage("再接再厉",font,new File("e:/c.png"),480,150);
//        createImage("Tissot机械表", new Font("微软雅黑", Font.PLAIN, 80), new File(
//                "e:/a.png"), 500, 150);
//        createImage("请A1002到2号窗口", new Font("黑体", Font.BOLD, 35), new File(
//                "e:/a1.png"), 4096, 64);
//        createImage("请A1001到1号窗口", new Font("黑体", Font.PLAIN, 40), new File(
//                "e:/a2.png"), 4096, 64);

    }

    /**
     * 根据str,font的样式以及输出文件目录
     * @param str	字符串
     * @param font	字体
     * @param outFile	输出文件位置
     * @param width	宽度
     * @param height	高度
     * @throws Exception
     */
    public static void createImage(String str, Font font, File outFile,
                                   Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics2D g = image.createGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.black);
        // 先用黑色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        // 在换成红色
        g.setColor(Color.white);
        // 设置画笔字体
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); // 去除锯齿(当设置的字体过大的时候,会出现锯齿)
        /** 用于获得垂直居中y */
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;
        // 256 340 0 680
//        for (int i = 0; i < 6; i++) {
//            // 画出字符串
//            g.drawString(str, i * 680, y);
//        }

        int fontLength = FontUtil.getStringLength(font,str);
        int x = (width - fontLength )/2;

        g.drawString(str, x, y); // 在指定坐标除添加文字
        g.dispose();
        // 输出png图片
        ImageIO.write(image, "png", outFile);
    }
}


