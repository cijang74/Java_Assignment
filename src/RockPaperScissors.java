import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

class RockPaperScissors
    // 기본 가위바위보 클래스
{
    // 상수 선언
    public final int ROCK = 0;
    public final int PAPER = 1;
    public final int SCISSORS = 2;

    // 뱐수 선언
    protected String playerA;
    protected String playerB;

    public String play(String playerA)
            // B가 가위바위보를 다른 메서드를 통해 얻어올 수 있도록 하는 메서드 (사용됨)
    {
        this.playerA = playerA;
        this.playerB = getRockPaperScissors();
        return getResult(this.playerA, this.playerB);
    }

    protected String getResult(String playerA, String playerB)
            // 결과를 만들어 내는 메서드
    {
        String result = "";
        result += "플레이어 A는 " + playerA + "를 냈습니다.\n";
        result += "플레이어 B는 " + playerB + "를 냈습니다.\n";

        result += "판정결과는 " + judge(playerA, playerB) + "\n";

        return result;
    }

    protected String getRockPaperScissors()
            // 플레이어 B(AI)가 가위바위보 중 하나를 랜덤으로 뽑게 함(오버로딩)
    {
        int result = (int)(Math.random()*3);

        if(result == SCISSORS)
        {
            return "가위";
        }

        else if(result == ROCK)
        {
            return "바위";
        }

        else
        {
            return "보";
        }
    }

    protected String judge(String playerA, String playerB)
            // 결과를 판정하는 메서드
    {
        if(playerA.equals(playerB))
        {
            return "플레이어 A와 플레이어 B가 비겼습니다.";
        }

        else if ((playerA.equals("가위") && playerB.equals("보")) || (playerA.equals("바위") && playerB.equals("가위"))
        || (playerA.equals("보") && playerB.equals("바위")))
        {
            return "플레이어 A가 이겼습니다.";
        }

        else
        {
            return "플레이어 B가 이겼습니다.";
        }
    }
}