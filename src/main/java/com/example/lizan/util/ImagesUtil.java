package com.example.lizan.util;

import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 把两张图片合并一张
 */
public class ImagesUtil {

    /**
     * 压缩图片
     */
    private static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
        // targetW，targetH分别表示目标长和宽
        int type = source.getType();
        BufferedImage target = null;
        int width = source.getWidth();
        int height = source.getHeight();
        double sx = (double) targetW / width;
        double sy = (double) targetH / height;
        // 这里想实现在targetW，targetH范围内实现等比缩放
        if (sx > sy) {
            sx = sy;
            targetW = (int) (sx * source.getWidth());
        } else {
            sy = sx;
            targetH = (int) (sy * source.getHeight());
        }
        if (type == BufferedImage.TYPE_CUSTOM) {
            ColorModel cm = source.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
                    targetH);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else {
            target = new BufferedImage(targetW, targetH, type);
        }
        Graphics2D g = target.createGraphics();
        // smoother than exlax:
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        return target;
    }


    /**
     * 待合并的两张张图必须满足这样的前提，如果水平方向合并，则高度必须相等；如果是垂直方向合并，宽度必须相等。
     *
     * @param img1 待合并的第一张图
     * @param img2 带合并的第二张图
     * @return 返回合并后的BufferedImage对象
     */
    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2) {

        Graphics2D graphics2D = null;
        // 生成新图片
        BufferedImage destImage = null;
        destImage = new BufferedImage(1280, 580, BufferedImage.TYPE_INT_RGB);
        graphics2D = destImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, 1280, 580);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawImage(img1, 40, 0, 580, 580, null);
        graphics2D.drawImage(img2, 620, 0, 580, 580, null);
        graphics2D.dispose();
        return destImage;
    }

    /**
     * 生成新图片到本地
     */
    public static File writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
                return outputfile;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
    }
}
