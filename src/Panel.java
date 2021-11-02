import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StyleOptionsPanel extends JPanel // 패키지 안에 있는 JPanel 클래스 상속
{
    private JLabel saying; // 라벨형 saying 변수 선언
    private JCheckBox bold, italic; // 체크박스형 bold, italic 변수 선언

    public StyleOptionsPanel()
    {
        saying = new JLabel("교수님 사랑해요"); // "교수님 사랑해요"라는 텍스트를 가진 라벨 객체 생성, saying 변수에 저장
        saying.setFont(new Font("Helvetica", Font.PLAIN, 36)); // saying 변수의 폰트 설정

        bold = new JCheckBox("Bold"); // "Bold" 체크 박스 생성 후 bold 변수에 저장
        bold.setBackground(Color.lightGray); // 체크박스 색상 설정

        italic = new JCheckBox("Italic"); // "Italic" 체크 박스 생성 후 italic 변수에 저장
        italic.setBackground(Color.lightGray); // 체크박스 색상 설정

        StyleListener listener = new StyleListener(); // StyleListener 객체 생성 후 listener 변수에 저장
        bold.addItemListener(listener); // bold 체크박스에 listener 효과 추가
        italic.addItemListener(listener); // ""

        // 컴포넌트에 추가
        add(saying);
        add(bold);
        add(italic);

        setBackground(Color.white); // 배경 색상 설정
        setPreferredSize(new Dimension(300, 100));
    }
    private class StyleListener implements ItemListener // 체크박스를 변경했을 때 실행되는 메서드
    {
        public void itemStateChanged(ItemEvent event) // 부모가 인터페이스라 무조건 오버라이딩 해줘야함~
        {
            int style = Font.PLAIN; // style 변수는 기본 형태의 폰트로 선언됨

            if (bold.isSelected()) // bold 체크박스가 체크되었다면
            {
                style = Font.BOLD;
            }

            if (italic.isSelected())
            {
                style += Font.ITALIC;
            }

            saying.setFont(new Font("Helvetica", style, 36)); // 앞에서 설정한 style을 가지고 라벨 생성
            return;
        }
    }
}