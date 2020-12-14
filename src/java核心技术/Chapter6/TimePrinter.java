package java核心技术.Chapter6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @ClassName TimePrinter
 * @Date 2020/10/9 14:53
 * @Created by sakura
 * 分析：
 **/
public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // ActionEvent 包含了产生这个回调的事件的相关信息。
        System.out.println("at the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
