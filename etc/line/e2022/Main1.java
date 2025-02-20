package net.skhu.line.e2022;

public class Main1 {

    static int solution(int[][] queries) {
        int[] count = new int[1001];
        int[] size = new int[1001];
        int answer = 0;
        for (int[] query : queries) {
            int a = query[0], b = query[1];
            if (count[a] + b > size[a]) {
                answer += count[a];
                count[a] += b;
                size[a] = (1 << (int)Math.ceil(Math.log(count[a]) / Math.log(2)));
            } else
                count[a] += b;
        }
        return answer;
    }

    public static void main(String[] args) {
        var a = new int[][] {{2,10},{7,1},{2,5},{2,9},{7,32}};
        System.out.println(solution(a));

        a = new int[][] {{1,1}, {1,2}, {1,4}, {1,8}};
        System.out.println(solution(a));
    }
}
