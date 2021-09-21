import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalSeconds = 0, change = 0, hours = 0, minutes = 0, seconds = 0;

        System.out.print("초를 입력하세요: ");
        totalSeconds = scan.nextInt();
        change = totalSeconds;

        hours = change / (60 * 60);
        change = change % (60 * 60);

        minutes = change / 60;
        seconds = change % 60;

        System.out.println(totalSeconds + "초는 " + hours + "시간 " + minutes + "분 " + seconds +"초입니다.");

        return;
    }
}