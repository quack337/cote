package ebay.e2018;

import java.util.Scanner;

/*
2018
아라비아 숫자를 로마문자로 바꾸기
 */
public class Ex3b {

    static int[] number = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static String[] words = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    static String toRom(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            for (int i = 0; i < number.length; ++i) {
                if (number[i] <= value && value < number[i + 1]) {
                    value -= number[i];
                    result.append(words[i]);
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
            System.out.println(toRom(sc.nextInt()));
        sc.close();
    }
}
