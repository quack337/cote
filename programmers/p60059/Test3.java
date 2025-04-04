package programmers.p60059;

public class Test3 {

    static class Solution {
        int[][] key, lock;

        int getKey(int 회전, int 행이동, int 열이동, int 행, int 열) {
            행 -= 행이동;
            열 -= 열이동;
            if (행 < 0 ||  key.length - 1 < 행) return 0;
            if (열 < 0 ||  key.length - 1 < 열) return 0;
            if (회전 == 1) { // 90도
                int t = 행;
                행 = key.length - 1 - 열;
                열 = t;
            } else if (회전 == 2) { // 180 도
                행 = key.length - 1 - 행;
                열 = key.length - 1 - 열;
            } else if (회전 == 3) { // 270 도
                int t = 행;
                행 = 열;
                열 = key.length - 1 - t;
            }
            return key[행][열];
        }

        boolean 일치하나(int 회전, int 행이동, int 열이동) {
            for (int 행 = 0; 행 < lock.length; ++행)
                for (int 열 = 0; 열 < lock.length; ++열)
                    if (getKey(회전, 행이동, 열이동, 행, 열) == lock[행][열]) return false;
            return true;
        }

        boolean solution(int[][] key, int[][] lock) {
            this.key = key;
            this.lock = lock;
            for (int 회전 = 0; 회전 < 4; ++회전)
                for (int 행이동 = -(key.length - 1); 행이동 < lock.length; ++ 행이동)
                    for (int 열이동 = -(key.length - 1); 열이동 < lock.length; ++ 열이동)
                        if (일치하나(회전, 행이동, 열이동)) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(new Solution().solution(key, lock));
    }
}