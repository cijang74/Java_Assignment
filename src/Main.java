import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String weatherReport = null;
        String newsMessage = null;

        System.out.print("오늘의 기상 특보를 입력하세요: ");
        weatherReport = scan.next();

        System.out.println("일부 지방에 " + weatherReport + "가 발효중입니다.");
        newsMessage = "출근길 " ;

        if (weatherReport.equals ("대설특보")){
            newsMessage += "눈길";
        }

        else if (weatherReport.equals ("호우특보")){
            newsMessage += "빗길";
        }

        else if (weatherReport.equals ("강풍주의보")){
            newsMessage += "안전";
        }

        newsMessage += " 운전에 유의해야 합니다.";
        System.out.println(newsMessage);

        return;
    }
}