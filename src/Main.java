import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = 0;

        System.out.print("년도를 입력하세요: ");
        year = scan.nextInt();

        if ((year % 400) == 0)
        {
            System.out.println(year + "년은 윤년입니다.");
        }

        else if ((year % 100) == 0)
        {
            System.out.println(year + "년은 평년입니다.");
        }

        else if ((year % 4) == 0)
        {
            System.out.println(year + "년은 윤년입니다.");
        }

        else System.out.println(year + "년은 평년입니다.");

        return;
    }
}