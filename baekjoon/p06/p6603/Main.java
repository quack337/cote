package baekjoon.p06.p6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void 선택하기(int[] S, int index, int count, List<Integer> selected) {
        if (count == 0) { // 선택이 끝났으면, 선택 목록 출력
            for (int i : selected)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        selected.add(S[index]);               // S[index] 항목을 선택 목록에 추가한다
        선택하기(S, index + 1, count - 1, selected); // 다음 단계 재귀호출
        selected.remove(selected.size() - 1); // S[index] 항목을 선택 목록에서 제거한다
        if (S.length - index > count)                  // S[index] 항목을 선택하지 않아도 되는가?
            선택하기(S, index + 1, count, selected);   // 선택하지 않고, 다음 단계 재귀호출
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int K = Integer.parseInt(tokenizer.nextToken());
            if (K == 0) break;
            int[] S = new int[K];
            for (int i = 0; i < K; ++i)
                S[i] = Integer.parseInt(tokenizer.nextToken());
            선택하기(S, 0, 6, new ArrayList<Integer>());
            System.out.println();
        }
    }
}
