import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Style Option"); // 프레임 이름
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new StyleOptionsPanel()); // 새 패널 객체를 생성한 후 컴포넌트에 추가하고 그 컴포넌트를 프레임에 추가

        frame.pack();
        frame.setVisible(true);

        return;
    }
}