package cn.disy920.autogui;

import cn.disy920.autogui.util.ImagePosition;

import java.awt.image.BufferedImage;

public class ImageFinder {

    public static ImagePosition findImagePos(BufferedImage image, BufferedImage imageToFind) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (image.getRGB(x, y) == imageToFind.getRGB(0,0)) {

                    int pixelsCounter = imageToFind.getWidth() * imageToFind.getHeight();

                    if (!(imageToFind.getHeight() + y > image.getHeight()) && !(imageToFind.getWidth() + x > image.getWidth())) {
                        for (int yy = y; yy < imageToFind.getHeight() + y; yy++) {
                            for (int xx = x; xx < imageToFind.getWidth() + x; xx++) {

                                if (image.getRGB(xx, yy) == imageToFind.getRGB(xx - x, yy - y)) {
                                    pixelsCounter--;
                                }
                                else {
                                    pixelsCounter = -1;
                                    break;
                                }
                            }
                            if (pixelsCounter == -1) {
                                break;
                            }
                        }
                        if (pixelsCounter == 0) {
                            return new ImagePosition(x, y, imageToFind.getWidth(), imageToFind.getHeight());
                        }
                    }
                }

            }
        }


        return null;
    }
}
