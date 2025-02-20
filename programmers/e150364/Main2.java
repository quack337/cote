package programmers.e150364;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Main2 {

    static ArrayList<Integer>[][] DP = new ArrayList[101][101];

    static void createDP(int count, int target) {
        for (int i = 1; i <= 3; ++i) {
            if (target + i > 100) continue;
            if (DP[count + 1][target + i] != null) continue;
            var list = new ArrayList<Integer>(DP[count][target]);
            list.add(i);
            DP[count + 1][target + i] = list;
            createDP(count + 1, target + i);
        }
    }

    public static void main(String[] args) {
        DP[0][0] = new ArrayList<Integer>();
        createDP(0, 0);
        for (int count = 0; count <= 100; ++count)
            for (int target = 0; target <= 100; ++target)
                if (DP[count][target] != null)
                    System.out.printf("%d %d %s\n", count, target, DP[count][target]);
    }
}

