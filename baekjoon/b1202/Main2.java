package baekjoon.b1202;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    static class Jewelry implements Comparable<Jewelry> {
        int 무게, 가격;
        boolean 선택;

        @Override
        public int compareTo(Jewelry j) { // 가격 내림차순, 무게 오름차순
            int r;
            if ((r = j.가격 - 가격) != 0) return r;
            return 무게 - j.무게;
        }
    }

    static Jewelry[] 보석목록;
    static int[] 가방목록;

    static int 가격합계(Jewelry[] 선택) {
        int sum = 0;
        for (Jewelry 보석 : 선택)
            sum += 보석.가격;
        return sum;
    }

    static int solution(Jewelry[] 선택, int index) {
        if (index >= 선택.length) return 가격합계(선택);
        int 가방 = 가방목록[index];
        int 최대금액 = 0;
        for (Jewelry 보석 : 보석목록) {
            if (보석.선택) continue;
            if (보석.무게 > 가방) continue;
            선택[index] = 보석;
            보석.선택 = true;
            int 금액 = solution(선택, index + 1);
            if (금액 > 최대금액) 최대금액 = 금액;
            보석.선택 = false;
        }
        return 최대금액;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            List<Jewelry> list = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                Jewelry 보석 = new Jewelry();
                보석.무게 = scanner.nextInt();
                보석.가격 = scanner.nextInt();
                list.add(보석);
            }
            가방목록 = new int[K];
            for (int i = 0; i < K; ++i)
                가방목록[i] = scanner.nextInt();
            Arrays.sort(가방목록);

            int 가방최대 = 가방목록[가방목록.length-1];
            Iterator<Jewelry> it = list.iterator();
            while (it.hasNext()) {
                Jewelry 보석 = it.next();
                if (보석.무게 > 가방최대) it.remove();
            }
            보석목록 = list.toArray(new Jewelry[list.size()]);
            Arrays.sort(보석목록);
            System.out.println(solution(new Jewelry[가방목록.length], 0));
        }
    }
}