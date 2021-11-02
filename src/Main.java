import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Push Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PushCounterPanel panel = new PushCounterPanel(); // Panel 객체를 생성
        frame.getContentPane().add(panel); //panel 객체에 있는 컴포넌트들을 불러와(getContentPane()) 프레임에 add함.

        frame.pack();
        frame.setVisible(true);

        return;
    }
}