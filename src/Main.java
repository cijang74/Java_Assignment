import java.lang.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 0, d = 0;
        c = ++a;
        d = b++;

        System.out.println("a = 3일 때 c = ++a 적용 후 결과 a = " + a + ",c = " + c);
        System.out.println("b = 3일 때 d = b++ 적용 후 결과 d = " + b + ",c = " + d);

        c = --a;
        d = b--;

        System.out.println("a = 4일 때 c = --a 적용 후 결과 a = " + a + ",c = " + c);
        System.out.println("b = 4일 때 d = b-- 적용 후 결과 d = " + b + ",c = " + d);

        return;
    }
}