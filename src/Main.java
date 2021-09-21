import java.lang.System;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int headsOrTails = 0, user = 0;

        System.out.println("동전 던지기 게임을 시작합니다.\n");
        System.out.print("앞면(0), 뒷면(1) 중 하나를 선택하세요: ");
        user = scan.nextInt();

        String choice = (user == 0) ? "동전 앞면을 선택했습니다." : "동전 뒷면을 선택했습니다.";
        System.out.println(choice);

        headsOrTails = (int)(Math.random() * 2 );

        String result = (headsOrTails == 0) ? "결과는 동전 앞면입니다." : "결과는 동전 뒷면입니다.";
        System.out.println(result);

        String answer = (headsOrTails == user) ? "맞췄습니다.\n" : "틀렸습니다.\n";
                System.out.println(answer);

        return;
    }
}