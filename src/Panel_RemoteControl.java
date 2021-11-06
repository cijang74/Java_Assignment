import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RemoteControlPanel extends JPanel
    // 해당 클레스는 버튼의 이미지와 리스너가 포함되어 있음
{
    // 각 경우의 수를 상수화
    final int POWER = 0;
    final int UP = 1;
    final int DOWN = 2;
    final int LEFT = 3;
    final int RIGHT = 4;

    private JButton[] btn; // 버튼배열 btn 선언
    private RemoteControl appliance; // RemoteControl 객체 appliance 선언

    public final String imgPath = "C:\\Users\\cijan\\Downloads\\JL06\\img\\"; //경로값을 imagPath에 저장
    private final String[] btnRC = {"power", "up", "down", "left", "right"}; // 이미지 이름값을 btnRC에 저장

    public RemoteControlPanel(RemoteControl appliance)
    {
        this.appliance = appliance; // 매개변수 appliance를 해당 객체의 appliance에 저장

        ButtonListener buttonListener = new ButtonListener(); // 버튼 리스너 객체 생성

        btn = new JButton[btnRC.length]; // 5개 공간만큼을 할당하여 버튼배열객체 생성

        for(int i = 0; i< btnRC.length; i++)
        // btn에 각 이미지와 버튼리스너를 삽입하는 반복문
        {
            btn[i] = new JButton(new ImageIcon(new ImageIcon(imgPath + btnRC[i] + ".gif")
                    .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

            btn[i].addActionListener(buttonListener);
        }

        this.setPreferredSize(new Dimension (170, 120)); // 리모컨 패널의 크기 설정
        this.setLayout(new BorderLayout()); // 가운데를 중심으로 동서남북으로 배치하는 레이아웃

        this.add(btn[POWER], BorderLayout.CENTER); // 가운데에는 전원
        this.add(btn[UP], BorderLayout.NORTH); // 북쪽에는 UP
        this.add(btn[DOWN], BorderLayout.SOUTH); // 남쪽에는 DOWN
        this.add(btn[LEFT], BorderLayout.WEST); // 서쪽에는 LEFT
        this.add(btn[RIGHT], BorderLayout.EAST); // 동쪽에는 EAST
    }
    private class ButtonListener implements ActionListener
    // 버튼을 눌렀을 때 발생되는 리스너
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == btn[POWER]) // 이벤트를 발생시킨 객체의 위치가 btn[POWER] 이라면
            {
                appliance.clickPower();
            }

            else if (event.getSource() == btn[UP])
            {
                appliance.clickUp();
            }

            else if (event.getSource() == btn[DOWN])
            {
                appliance.clickDown();
            }

            else if (event.getSource() == btn[LEFT])
            {
                appliance.clickLeft();
            }

            else
            {
                appliance.clickRight();
            }
        }
    }
}

