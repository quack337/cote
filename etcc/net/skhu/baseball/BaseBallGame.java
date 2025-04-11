package etcc.net.skhu.baseball;
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;

class CompareResult {
    private int strike, ball;

    public CompareResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (strike == 3) builder.append("정답");
        else if (strike == 0 && ball == 0) builder.append("아웃");
        else {
             if (strike > 0) builder.append(strike).append("스트라이크 ");
             if (ball > 0) builder.append(ball).append("볼 ");
        }
        return builder.toString();
    }
}

public class BaseBallGame {
    static Random random = new Random();

    static CompareResult compare(char[] n1, char[] n2) {
        int strike = 0, ball = 0;
        BitSet digits1 = new BitSet(10);
        for (int i = 0; i < n1.length; ++i) {
            if (n1[i] == n2[i])
                ++strike;
            digits1.set(n1[i] - '0');
        }
        for (int i = 0; i < n2.length; ++i) {
            if (n1[i] != n2[i] && digits1.get(n2[i] - '0'))
                ++ball;
        }
        return new CompareResult(strike, ball);
    }

    static char[] createRandomNumber() {
        char[] n = new char[3];
        int i = 0;
        while (i < n.length) {
            char c = (char)(random.nextInt(9) + '1');
            if (i == 1 && n[1] == n[0]) continue;
            if (i == 2 && (n[2] == n[1] || n[2] == n[0])) continue;
            n[i++] = c;
        }
        return n;
    }

    static void run(Scanner scanner) {
        char[] n1 = createRandomNumber();
        System.out.println(n1);
        while (true) {
            System.out.print("숫자를 입력: ");
            String s = scanner.next();
            if (s.matches("[1-9]{3}") == false) continue;
            char[] n2 = s.toCharArray();
            CompareResult result = compare(n1, n2);
            System.out.println(result);
            if (result.getStrike() == 3) break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            run(scanner);
            System.out.print("게임을 계속하시겠습니까? (1=계속,0=종료) ");
            if (scanner.nextInt() == 0) break;
        }
        scanner.close();
    }
}