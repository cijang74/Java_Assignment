import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ReboundPanel extends JPanel // 패키지 안에 있는 JPanel 클래스 상속
{
    // 변수, 상수 선언
    private final int WIDTH = 300, HEIGHT = 100;
    private final int DELAY = 20, IMAGE_SIZE = 35;
    private ImageIcon image;
    private Timer timer;
    private int x, y, moveX, moveY;

    public ReboundPanel() // 생성자
    {
        timer = new Timer(DELAY, new ReboundListener()); // Timer 객체는 DELAY(20) 밀리세컨 1000분의 1초 마다 같은 동작을 반복한다.
        image = new ImageIcon("happyFace.gif"); // 이미지 설정

        // default 위치
        x = 0;
        y = 40;

        // 이동속도
        moveX = moveY = 3;

        // WIDTH, HEIGHT 만큼의 디스플레이 크기 설정
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);

        // 타이머 시작
        timer.start();
    }

    public void paintComponent(Graphics page)
    // 자기 자신을 그리는 메서드
    {
        super.paintComponent(page);
        image.paintIcon(this, page, x, y); // this 컴포넌트의 x,y 좌표에 자기 자신을 그림
    }
    private class ReboundListener implements ActionListener
        // 타이머가 돌아갈 때 마다 계속해서 실행될 메서드
    {
        public void actionPerformed(ActionEvent event)
        {
            // 이동 속도만큼 계속해서 이동
            x += moveX;
            y += moveY;

            if (x <= 0 || x >= WIDTH - IMAGE_SIZE) // 테두리에 닿으면
            {
                moveX = moveX * -1; // 이동속도에 -1을 곱해주어 반대쪽으로 이동하도록 함
            }

            if ( y<= 0 || y >= HEIGHT - IMAGE_SIZE) // ""
            {
                moveY = moveY * -1; // ""
            }

            repaint(); // 이미지가 계속 움직이는것을 실시간으로 blit해주기 위해 paintComponent 강제 실행
        }
    }
}