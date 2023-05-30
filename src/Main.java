import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        checkLeapYear();
    }

    private static void checkLeapYear() {
        // 윤년 알아맞추기
        int year = 1700;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + "O");
        } else {
            System.out.println(year + "X");
        }
    }
}
