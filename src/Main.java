import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Light Bulb");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LightBulbPanel bulb = new LightBulbPanel(); // 전구 패널 생성 (전구 이미지를 띄워주는 컴포넌트)
        LightBulbControls controls = new LightBulbControls(bulb); // 컨트롤러 패널 생성 (On / Off 버튼)

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        // setLayout: 레이아웃 매니저를 생성- 박스 레이아웃(일렬로 배치하는 레이아웃), 인자는 정렬방법(상 -> 하 배치)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Box.createRigidArea: 정적 컴포넌트 생성
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // 너비 0, 높이 20
        panel.add(bulb); // 해당 컴포넌트에 bulb 컴포넌트 삽입

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(controls);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);

        return;
    }
}