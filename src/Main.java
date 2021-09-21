import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;

        System.out.println("0점 ~ 100점 사이의 점수를 입력하세요: ");
        score = scan.nextInt();

        switch (score / 10){
            case 10: case 9:
                System.out.println("와! ");
            case 8:
                System.out.println("끝내주게 !");
            case 7:
                System.out.println("잘 ");
            default:
                System.out.println("했다");
        }

        return;
    }
}