import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LightBulbPanel extends JPanel
{
    // 변수 선언
    private boolean on;
    private ImageIcon lightOn, lightOff;
    private JLabel imageLabel;

    public LightBulbPanel() // 생성자
    {
        // 이미지 불러오기
        lightOn = new ImageIcon("lightBulbOn.gif");
        lightOff = new ImageIcon("lightBulbOff.gif");

        setBackground(Color.black);
        on = true; // 전구의 defualt 상태는 켜져있음

        imageLabel = new JLabel(lightOff);
        add(imageLabel);
    }

    public void paintComponent(Graphics page)
    // 자기 자신을 그리는 컴포넌트
    {
        super.paintComponent(page);

        if(on) // 전구가 켜져있다면
        {
            imageLabel.setIcon(lightOn); // 켜져있는 이미지 blit
        }

        else // 전구가 꺼져있다면
        {
            imageLabel.setIcon(lightOff); // 꺼져있는 이미지 blit
        }
    }

    public void setOn(boolean lightBulbOn)
    // 인자를 전달받아 해당 클래스에서 private로 선언된 on을 수정해주는 매서드
    {
        on = lightBulbOn;
    }
}