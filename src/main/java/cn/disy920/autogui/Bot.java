package cn.disy920.autogui;

import cn.disy920.autogui.util.Coordinate;
import cn.disy920.autogui.util.ImagePosition;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bot {
    public static Robot BOT_INSTANCE;  // 暴露出的AWT Robot实例，可以进行额外的操作

    public Bot() throws AWTException {
        BOT_INSTANCE = new Robot();
    }


    /**
     * 移动光标到指定坐标点
     * @param x x坐标值
     * @param y y坐标值
     */
    public void mouseMove(int x, int y){
        BOT_INSTANCE.mouseMove(x, y);
    }


    /**
     * 从当前位置出发，移动光标位置
     * @param x x偏移量，正值向右移动，负值向左移动
     * @param y y偏移量，正值向下移动，负值向上移动
     */
    public void mouseMoveRel(int x, int y){
        Point point = MouseInfo.getPointerInfo().getLocation();
        BOT_INSTANCE.mouseMove(point.x + x, point.y + y);
    }


    /**
     * 获取光标当前的坐标
     * @return 一个坐标组，表示当前光标的位置
     */
    public Coordinate mousePosition(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        return new Coordinate(point.x, point.y);
    }


    /**
     * 模拟双击鼠标按键
     * @param button 按键名称，left为左键（默认值），middle为中键，right为右键
     */
    public void mouseClick(String button){
        switch (button.toLowerCase()) {
            default -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
            case "right" -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
            case "middle" -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            }
        }
    }


    /**
     * 模拟双击鼠标按键
     * @param button 按键名称，left为左键（默认值），middle为中键，right为右键
     */
    public void mouseDoubleClick(String button){
        switch (button.toLowerCase()) {
            default -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                BOT_INSTANCE.delay(200);
                BOT_INSTANCE.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
            case "right" -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                BOT_INSTANCE.delay(200);
                BOT_INSTANCE.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
            case "middle" -> {
                BOT_INSTANCE.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                BOT_INSTANCE.delay(200);
                BOT_INSTANCE.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                BOT_INSTANCE.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            }
        }
    }


    /**
     * 模拟人咧输入一串文字（仅限英文字母、数字与部分符号）
     * @param text 待输入的文字
     */
    public void typewrite(String text){
        this.typewrite(text, 20);
    }


    /**
     * 模拟间隔一段时间输入一串文字（仅限英文字母、数字与部分符号）
     * @param text 待输入的文字
     * @param interval 间隔时长
     */
    public void typewrite(String text, int interval){
        for(byte c : text.toUpperCase().getBytes(StandardCharsets.UTF_8)){
            switch (c){
                case '0' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_0);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_0);
                }
                case '1' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_1);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_1);
                }
                case '2' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_2);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_2);
                }
                case '3' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_3);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_3);
                }
                case '4' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_4);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_4);
                }
                case '5' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_5);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_5);
                }
                case '6' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_6);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_6);
                }
                case '7' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_7);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_7);
                }
                case '8' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_8);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_8);
                }
                case '9' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_9);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_9);
                }
                case 'A' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_A);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_A);
                }
                case 'B' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_B);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_B);
                }
                case 'C' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_C);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_C);
                }
                case 'D' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_D);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_D);
                }
                case 'E' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_E);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_E);
                }
                case 'F' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_F);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_F);
                }
                case 'G' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_G);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_G);
                }
                case 'H' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_H);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_H);
                }
                case 'I' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_I);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_I);
                }
                case 'J' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_J);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_J);
                }
                case 'K' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_K);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_K);
                }
                case 'L' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_L);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_L);
                }
                case 'M' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_M);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_M);
                }
                case 'N' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_N);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_N);
                }
                case 'O' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_O);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_O);
                }
                case 'P' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_P);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_P);
                }
                case 'Q' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_Q);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_Q);
                }
                case 'R' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_R);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_R);
                }
                case 'S' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_S);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_S);
                }
                case 'T' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_T);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_T);
                }
                case 'U' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_U);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_U);
                }
                case 'V' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_V);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_V);
                }
                case 'W' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_W);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_W);
                }
                case 'X' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_X);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_X);
                }
                case 'Y' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_Y);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_Y);
                }
                case 'Z' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_Z);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_Z);
                }
                case ',' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_COMMA);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_COMMA);
                }
                case '.' -> {
                    BOT_INSTANCE.keyPress(KeyEvent.VK_PERIOD);
                    BOT_INSTANCE.delay(interval);
                    BOT_INSTANCE.keyRelease(KeyEvent.VK_PERIOD);
                }
            }
        }
    }


    /**
     * 模拟人类单击某键盘按键
     * @param key 要点击的按键编码
     */
    public void keyClick(int key){
        BOT_INSTANCE.keyPress(key);
        BOT_INSTANCE.delay(200);
        BOT_INSTANCE.keyRelease(key);
    }


    /**
     * 模拟操作鼠标滚轮，单位：个凹口
     * 正值向下滚动，负值向上滚动
     * @param pixel 滚动的“凹口”数量
     */
    public void mouseWheel(int pixel){
        BOT_INSTANCE.mouseWheel(pixel);
    }


    /**
     * 全屏截图
     * @return 返回存有截图的BufferedImage
     */
    public BufferedImage getFullScreenShot() {
        BufferedImage bfImage;
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        bfImage = BOT_INSTANCE.createScreenCapture(new Rectangle(0, 0, width, height));
        return bfImage;
    }


    /**
     * 获取指定图片在屏幕上的坐标
     * @param imagePath 指定图片的路径
     * @return 一个二维坐标点，如果未找到则返回null
     * @throws IOException 当指定图片打开或读取出错时抛出
     */
    public ImagePosition locateOnScreen(String imagePath) throws IOException {
        return ImageFinder.findImagePos(getFullScreenShot(), ImageIO.read(Files.newInputStream(Paths.get(imagePath))));
    }
}
