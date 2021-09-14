import java.lang.System;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int year = 0;
        int month = 0;
        int day = 0;

        System.out.print("당신이 태어난 년도를 입력하세요.: ");
        year = scan.nextInt();

        System.out.print("당신이 태어난 달을 입력하세요.: ");
        month = scan.nextInt();

        System.out.print("당신이 태어난 날을 입력하세요.: ");
        day = scan.nextInt();

        System.out.println("\n당신은 " + year + "년 " + month + "월 " + day + "일에 태어났군요. 당신은 사랑받기 위해 태어난사람");
        return;
    }
}