import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RCCarPanel extends JPanel implements RemoteControl
// 해당 클레스에는 버튼을 눌렀을 때 발생하는 이벤트들이 포함되어 있음
{
    private boolean power;
    private RemoteControlPanel rc;
    private RoadPanel road;

    public RCCarPanel()
    {
        power = OFF;

        rc = new RemoteControlPanel(this); // 버튼 이미지와 리스너가 포함된 RemoteControl 객체를 생성
        road = new RoadPanel(rc.imgPath); // 자동차와 도로가 포함된 RoadPanel 객체를 생성

        // 패널에 추가
        add(rc);
        add(road);
    }

    public void clickPower()
    {
        if (power == OFF)
        {
            road.setBackground(Color.green); // 전원이 켜지면 도로를 초록색으로 변경
            power = ON;
        }

        else
        {
            road.setBackground(null); // 전원이 꺼지면 도로 색값을 null로 변경
            power = OFF;
        }
    }

    public void clickUp ()
    {
        if (power == ON)
        {
            road.moveCar(0, -10);
        }
    }

    public void clickDown ()
    {
        if (power == ON)
        {
            road.moveCar(0, 10);
        }
    }

    public void clickLeft ()
    {
        if (power == ON)
        {
            road.moveCar(-10, 0);
        }
    }

    public void clickRight ()
    {
        if (power == ON)
        {
            road.moveCar(10, 0);
        }
    }
}
