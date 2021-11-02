import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PushCounterPanel extends JPanel
{
    private int count;
    private JButton push;
    private JLabel label;

    public PushCounterPanel()
    {
        count = 0;

        push = new JButton("Push Me!"); // Push Me!라는 버튼 객체를 생성하고 push 변수에 넣음
        push.addActionListener(new ButtonListener());

        label = new JLabel("Pushes: " + count); // 문자열 "Pushes: "과 변수 count를 출력시켜출 라벨 객체 생성 후 label 변수에 넣음

        add(push); // 컴포넌트에 주가
        add(label); // 컴포넌트에 추가

        setBackground(Color.gray);
        setPreferredSize(new Dimension(300, 40)); // 픽셀로 계산하여 가로 300, 세로 40
    }

    private class ButtonListener implements ActionListener // 버튼을 클릭한 이벤트가 발생했는지 살피는 리스너
    {
        public void actionPerformed(ActionEvent event) // 이벤트 발생하면
        {
            count++;
            label.setText("Pushes: " + count);

            return;
        }
    }
}