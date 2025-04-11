package etcc.ebay.e2018;
import java.util.Scanner;

/*
2018
아라비아 숫자를 로마문자로 바꾸기
 */
public class Ex3 {

    static int[] number = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static String[] words = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    static String print(String s, String result){
        result+=s;
        System.out.printf(result);
        return result;
    }

    static int toRom(int num, String result) {

        if(num==1){
            print(words[0],result);
            return 0;
        }

        int arabic = num;

        for (int i = 0; i < number.length; ++i) {

            if (arabic == number[i]) {
                print(words[i],result);
                return 0;
            }

            if (arabic > number[i] && arabic < number[i + 1]) {
                arabic -= number[i];
                print(words[i],result);
            }
        }
        return toRom(arabic,result);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String result="";
            toRom(sc.nextInt(),result);
            System.out.println(result);
        }
    }
}