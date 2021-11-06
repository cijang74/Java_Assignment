import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame("에어콘");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AirConditionerPanel panel = new AirConditionerPanel(); // TVPanel 객체 생성, panel에 저장
        frame.getContentPane().add(panel); // panel을 프레임에 추가

        frame.pack();
        frame.setVisible(true);

        return;
    }
}