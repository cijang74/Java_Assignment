import java.util.Scanner;

class RockPaperScissors
{
    public final int ROCK = 0;
    public final int PAPER = 1;
    public final int SCISSORS = 2;

    private String playerA;
    private String playerB;

    public RockPaperScissors()
    {
        this.playerA = "가위";
        this.playerB = "바위";
    }// 생성자는 return을 적지 않는다

    public String play(Scanner scan) // 오버로딩
    {
        this.playerA = getRockPaperScissors(scan);
        this.playerB = getRockPaperScissors();
        String result = getResult(this.playerA, this.playerB);

        return result;
    }

    public String play(String playerA) // 오버로딩
    {
        this.playerA = playerA;
        this.playerB = getRockPaperScissors();
        String result = getResult(this.playerA, this.playerB);
        return result;
    }

    private String getResult(String playerA, String playerB)
    {
        String result = "";
        result += "플레이어 A는" + playerA + "를 냈습니다.\n";
        result += "플레이어 B는" + playerB + "를 냈습니다.\n";

        result += "판정결과는" + judge(playerA, playerB) + "\n";
        return result;
    }

    private String getResult()
    {
        return getResult(this.playerA, this.playerB);
    }

    private String getRockPaperScissors(Scanner scan)
    {
        String result = "";

        do
        {
            System.out.print("가위, 바위, 보 중 하나를 입력하세요: ");
            result = scan.next();
        } while (!result.equals("가위") && !result.equals("바위") && !result.equals("보"));
        return result;
    }

    private  String getRockPaperScissors()
    {
        int num = (int)(Math.random()*3);
        String result = "";

        if (num == SCISSORS)
        {
            result = "가위";
        }

        else if (num == ROCK)
        {
            result = "바위";
        }

        else
        {
            result = "보";
        }
        return result;
    }

    private String judge(String playerA, String playerB)
    {
        String result = "";
        if (playerA.equals((playerB)))
        {
            result = "플레이어 A와 플레이어 B가 비겼습니다.";
        }
        else if ((playerA.equals("가위") && playerB.equals("보")) ||
                (playerA.equals("바위") && playerB.equals("가위")) ||
                (playerA.equals("보") && playerB.equals("바위")))
        {
            result = "플레이어 A가 이겼습니다";
        }
        else
        {
            result = "플레이어 B가 이겼습니다.";
        }
        return result;
    }
}

public class Main
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();
        String result = game.play(scan);
        System.out.println(result);

        return;
    }
}