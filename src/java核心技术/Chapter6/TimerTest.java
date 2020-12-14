package java核心技术.Chapter6;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @ClassName TimerTest
 * @Date 2020/10/9 14:52
 * @Created by sakura
 * 分析：
 **/
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);

    }
}
