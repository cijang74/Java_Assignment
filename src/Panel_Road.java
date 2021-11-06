import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RoadPanel extends JPanel
// 해당 클래스에는 도로와 자동차 정보가 포함되어 있음
{
    // 상수와 변수들 선언
    private final int WIDTH = 300, HEIGHT = 120;
    private final int IMAGE_SIZE = 30;
    private ImageIcon image;
    private int x, y;

    public RoadPanel(String imgPath)
    // 매개변수는 이미지 경로
    {
        x = y = 0;
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // 도로 패널의 크기 설정
        image = new ImageIcon(new ImageIcon(imgPath + "car.gif").getImage(). // 자동차 이미지 불러오기
                getScaledInstance(IMAGE_SIZE,IMAGE_SIZE,Image.SCALE_SMOOTH)); // SCALE_SMOOTH를 사용하면 느리지만 이미지 품질 상승
    }

    public void paintComponent(Graphics page)
    // 자기 자신을 그리는 매서드
    {
        super.paintComponent(page);
        image.paintIcon(this,page,x,y);
    }

    public void moveCar(int moveX, int moveY)
    // 자동차를 움직이는 메서드
    {
        x += moveX;
        y += moveY;

        if(x <= 0)
        {
            x = 0;
        }

        else if(x >= (WIDTH - IMAGE_SIZE))
        {
            x = WIDTH - IMAGE_SIZE;
        }

        if (y <= 0)
        {
            y = 0;
        }

        else if (y >= (HEIGHT - IMAGE_SIZE))
        {
            y = (HEIGHT - IMAGE_SIZE);
        }

        repaint(); // 자기 자신을 그리는 메서드를 강제로 호출
    }
}