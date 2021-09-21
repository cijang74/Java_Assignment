import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int month = 0;

        System.out.print("1월 ~ 12월 사이의 월을 입력하세요.: ");
        month = scan.nextInt();

        switch (month){
            case 1:
                System.out.println("1월의 영어 이름은 January 입니다.");
                break;
            case 2:
                System.out.println("2월의 영어 이름은 February 입니다.");
                break;
            case 3:
                System.out.println("3월의 영어 이름은 March 입니다.");
                break;
            case 4:
                System.out.println("4월의 영어 이름은 April 입니다.");
                break;
            case 5:
                System.out.println("5월의 영어 이름은 May 입니다.");
                break;
            case 6:
                System.out.println("6월의 영어 이름은 June 입니다.");
                break;
            case 7:
                System.out.println("7월의 영어 이름은 July 입니다.");
                break;
            case 8:
                System.out.println("8월의 영어 이름은 August 입니다.");
                break;
            case 9:
                System.out.println("9월의 영어 이름은 September 입니다.");
                break;
            case 10:
                System.out.println("10월의 영어 이름은 October 입니다.");
                break;
            case 11:
                System.out.println("11월의 영어 이름은 November 입니다.");
                break;
            default:
                System.out.println("12월의 영어 이름은 December 입니다.");
                break;
        }

        return;
    }
}