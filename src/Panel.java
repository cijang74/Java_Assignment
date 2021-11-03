import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CoordinatesPanel extends JPanel // 패키지 안에 있는 JPanel 클래스 상속
{
    // 변수, 상수 선언
    private final int Size = 6;
    private int x = 50, y = 50;

    public CoordinatesPanel()
    {
        addMouseListener(new CoordinatesListener()); // CoordinatesListener()에서 설정한 리스너를 마우스 리스너로 추가
        setBackground(Color.black); // 바디 배경을 검은색으로 설정
        setPreferredSize(new Dimension(300, 200)); // 프레임 크기 설정
    }

    public void paintComponent(Graphics page)
    // 자기 자신을 그리는 메서드
    {
        super.paintComponent(page);
        page.setColor(Color.green);
        page.fillOval(x,y,Size,Size); // 페이지의 50,50 좌표에 6x6만큼의 사각형 그리기
        // 페이지에 문자열 그리기 (인수는 순서대로 그릴 문자열, x좌표, y좌표)
        page.drawString("Coordinates: (" + x + y + ")", 5, 15);
    }

    private class CoordinatesListener implements MouseListener
    // 마우스와 관련된 이벤트들을 입력받는 메서드
    {
        public void mousePressed (MouseEvent event) //마우스를 눌렀을 때
        {
            // x, y값을 현재 마우스 위치값으로 저장
            x = event.getX();
            y = event.getY();

            repaint(); // 자기 자신을 그리는 메서드 강제 호출
        }

        // 아래 이벤트 메서드는 해당 함수에서 사용되지 않으므로 따로 설정 x
        public void mouseClicked (MouseEvent event) {}
        public void mouseReleased (MouseEvent event) {}
        public void mouseEntered (MouseEvent event) {}
        public void mouseExited (MouseEvent event) {}
    }
}