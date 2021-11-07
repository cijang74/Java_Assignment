import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

class RockPaperScissors_Lose extends RockPaperScissors
    // 지는 가위바위보 게임 클래스는 기본 가위바위보 게임을 상속받는다.
{
    public String judge(String playerA, String playerB)
            // playerA와 playerB의 문자열을 매개변수로 받아와 승패를 판단하는 매서드를 오버라이딩
    {
        String result = super.judge(playerA, playerB); // 부모클래스의 승패판정 매서드 결과값을 result에 저장

        // 승 패 결과 바꿔주기
        if(result.equals("플레이어 A가 이겼습니다."))
        {
            return "플레이어 B가 이겼습니다.";
        }

        else if(result.equals("플레이어 B가 이겼습니다."))
        {
            return "플레이어 A가 이겼습니다.";
        }

        else // 비겼을 때의 경우
        {
            return result; // 부모클래스의 승패판정 매서드 결과값을 그대로 사용
        }
    }
}