package com.ron.rao.common;

import java.awt.*;
import java.io.*;

public class CyFont {
    private Font definedFont = null;

    public Font getDefinedFont(String fontUrl,float fs) {
        if (definedFont == null) {
            InputStream is = null;
            BufferedInputStream bis = null;
            try {
                is =new FileInputStream(new File(fontUrl));
                bis = new BufferedInputStream(is);
                definedFont = Font.createFont(Font.TRUETYPE_FONT, is);
                //设置字体大小，float型
                definedFont = definedFont.deriveFont(fs);
            } catch (FontFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != is) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return definedFont;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CyFont cf=new CyFont();
//        cf.getDefinedFont(1, 50.0);

    }

}