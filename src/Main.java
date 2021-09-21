import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int payment = 0, change = 0, coin500 = 0, coin100 = 0, coin50 = 0, coin10 = 0;

        System.out.print("돈을 입력하세요: ");
        payment = scan.nextInt();
        change = payment;

        coin500 = change / 500;
        change = change % 500;

        coin100 = change / 100;
        change = change % 100;

        coin50 = change / 50;
        change = change % 50;

        coin10 = change / 10;
        change = change % 10;

        System.out.println(payment + "원을" );
        System.out.println("500원짜리 동전" + coin500 + "개, ");
        System.out.println("100원짜리 동전" + coin100 + "개, " );
        System.out.println("50원짜리 동전" + coin50 + "개, ");
        System.out.println("10원짜리 동전" + coin10 + "개로 거슬러 드립니다." );

        return;
    }
}