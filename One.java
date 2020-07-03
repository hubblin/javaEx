package code16;

import java.util.Scanner;

public class One {
    public static void main(final String[] args) {
        final Scanner ko = new Scanner(System.in);
        final int a = ko.nextInt();
        final int b = ko.nextInt();

        System.out.println("안녕하세요!!");

        final int result = power(a, b);

        System.out.println(result);

        ko.close();
    }

    public static int power(final int a, final int b) {
    return (int)Math.pow(a,b);
    }
}


