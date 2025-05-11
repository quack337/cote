package baekjoon.b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void 선택하기(int[] S, int index, int count, List<Integer> selected) {
        if (count == 0) {
            for (int i : selected)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        selected.add(S[index]);
        선택하기(S, index + 1, count - 1, selected);
        selected.remove(selected.size() - 1);
        if (S.length - index > count)
            선택하기(S, index + 1, count, selected);
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
