package net.skhu.brother;

public class Exam05 {

    static int count369(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9)
                ++count;
            number = number / 10;
        }
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