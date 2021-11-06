import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AirConditionerPanel extends JPanel implements RemoteControl
// 해당 클레스에는 로고와 TV 볼륨 이미지와 버튼을 눌렀을 때 발생하는 이벤트들이 포함되어 있음
{
    private RemoteControlPanel rc;
    private boolean power;
    private int temperature;
    private int windStrength;
    private final String strWindStrength[] = {"미풍", "약풍", "강풍"}; // 문자열 상수화
    private JLabel label;

    public AirConditionerPanel()
    {
        power = OFF;
        temperature = 18;
        windStrength = 1;
        rc = new RemoteControlPanel(this); // 버튼 이미지와 리스너가 포함된 RemoteControl 객체를 생성
        label = new JLabel(""); // 라벨 객체 생성

        // 패널 기초 설정
        label.setPreferredSize(new Dimension(290, 120));
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setForeground(Color.BLUE);

        // 패널에 추가
        add(rc);
        add(label);
    }

    public void clickPower()
            // 전원을 눌렀을 때
    {
        if (power == OFF) // 꺼져있으면
        {
            power = ON;
            label.setText("<html>희망온도: " + temperature + "도 <br> 바람세기: "
                    + strWindStrength[windStrength] + " </html>");
        }

        else
        {
            power = OFF; // 켜져있으면
            label.setText("");
        }
    }

    public void clickUp ()
            // 위 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            ++temperature;
            label.setText("<html>희망온도: " + temperature + "도 <br> 바람세기: "
                    + strWindStrength[windStrength] + " </html>");
        }
    }

    public void clickDown ()
            // 아래 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            --temperature;
            label.setText("<html>희망온도: " + temperature + "도 <br> 바람세기: "
                    + strWindStrength[windStrength] + " </html>");
        }
    }

    public void clickLeft ()
            // 왼쪽 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            windStrength = (windStrength + (strWindStrength.length - 1)) % strWindStrength.length;
            // 게속 누르면 값이 무한히 증가하므로 out of range 되기에 나머지값을 이용
            label.setText("<html>희망온도: " + temperature + "도 <br> 바람세기: "
                    + strWindStrength[windStrength] + " </html>");
        }
    }

    public void clickRight ()
    {
        if (power == ON)
        {
            windStrength = (windStrength + 1) % strWindStrength.length;
            label.setText("<html>희망온도: " + temperature + "도 <br> 바람세기: "
                    + strWindStrength[windStrength] + " </html>");
        }
    }
}
