package net.skhu.brother;

public class Exam05a {

    static int count369(int number) {
        int count = 0;
        for (char c : String.valueOf(number).toCharArray())
            if (c == '3' || c == '6' || c == '9')
                ++count;
        return count;
    }

    public static int solution2(int number) {
        int sum = 0;
        for (int i = 1; i <= number; ++i)
            sum += count369(i);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution2(13));
        System.out.println(solution2(33));
    }
}
