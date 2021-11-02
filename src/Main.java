import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 이번 예제는 메인 함수에서 모두 구현되었음
public class Main
{
    public static void main(String[] args)
    {
        // 변수 선언
        String numStr, result;
        int num, again;

        do // 일단 한번 해보고 조건을 만족하면 계속 반복
        {
            // JOptionPane을 사용하면 기본적으로 제공되는 컴포넌트가 포함된 프레임을 띄워준다.
            // showInputDialog에서는 사용자의 한 줄 입력을 받는 다이얼로그를 제공한다.
            numStr = JOptionPane.showInputDialog("Enter an integer: ");

            num = Integer.parseInt(numStr); // 문자열이었으니까 정수형으로 변환

            result = "That number is " + ((num%2 == 0)? "even" : "odd"); // 짝수면 even, 홀수면 odd를 넣어 라벨 수정
            // showMessageDialog에서는 메세지를 보여주는 다이얼로그를 제공한다.
            JOptionPane.showMessageDialog(null, result);

            // showConfirmDialog에서는 사용자로부터 Yes/No 응답을 입력받는 확인 다이얼로그를 제공한다.
            // 해당 다이얼로그에서는 사용자가 선택한 Yes/No 값을 리턴한다.
            again = JOptionPane.showConfirmDialog(null, "Do Another?");
        }while (again == JOptionPane.YES_OPTION); // 사용자가 Yes를 선택했다면 계속 반복

        return;
    }
}