import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LightBulbControls extends JPanel // 패키지 안에 있는 JPanel 클래스 상속
{
    // 패널, 버튼 선언 (구현은 아직 x)
    private LightBulbPanel bulb;
    private JButton onButton, offButton;

    public LightBulbControls(LightBulbPanel bulbPanel)
    // 컨트롤러 구현, 매개변수는 Panel 클래스에서 만든 bulb
    {
        bulb = bulbPanel; // Panel 클래스에서 만든 bulb를 이 클래스의 지역변수 bulb에 저장

        // onButton 구현
        onButton = new JButton("On"); // 생성
        onButton.setEnabled(false); // setEnabled: 버튼의 활성화를 제어하는 메서드, onButton의 default값은 비활성화
        onButton.setMnemonic('n'); // 단축키 설정 (ALT + n)
        onButton.setToolTipText("Turn it on!"); // 툴팁 설정 (마우스 커서 위에 가만히 올리면 보여지는 설명)
        onButton.addActionListener(new OnListener()); // OnListener을 액션 리스너로 설정

        offButton = new JButton("Off");
        offButton.setEnabled(true);
        offButton.setMnemonic('f');
        offButton.setToolTipText("Turn it off!");
        offButton.addActionListener(new OffListener());

        setBackground(Color.black); // 배경은 검정

        // 버튼들을 컴포넌트에 추가
        add(onButton);
        add(offButton);
    }

    private class OnListener implements ActionListener
        // On 버튼을 눌렀을 때 발생되는 이벤트를 관리하는 리스너
    {
        public void actionPerformed(ActionEvent event)
        {
            bulb.setOn(true); // bulb를 true로 바꿔 이미지를 켜져있는 전구 이미지로 blit

            // 버튼들의 활성화 제어
            onButton.setEnabled(false);
            offButton.setEnabled(true);

            // 자기 자신을 그리는 메서드 강제 실행
            bulb.repaint();
        }
    }

    private class OffListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            bulb.setOn(false);
            onButton.setEnabled(true);
            offButton.setEnabled(false);
            bulb.repaint();
        }
    }
}