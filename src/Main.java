import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String player1 = null;
        String player2 = null;

        System.out.print("A양, 가위, 바위, 보 중 하나를 선택하세요: ");
        player1 = scan.nextLine().trim();
        System.out.println(player1 + "를 냈습니다.");

        System.out.print("B군, 가위, 바위, 보 중 하나를 선택하세요: ");
        player2 = scan.nextLine().trim();
        System.out.println(player2 + "를 냈습니다.");

        if (player1.equals(player2))
        {
            System.out.println("\n비겼습니다.");
        }

        else if (player1.equals("가위") && player2.equals("보"))
        {
            System.out.println("A양이 이겼습니다.");
        }

        else if (player1.equals("바위") && player2.equals("가위"))
        {
            System.out.println("A양이 이겼습니다.");
        }

        else if (player1.equals("보") && player2.equals("바위"))
        {
            System.out.println("A양이 이겼습니다.");
        }

        return;
    }
}