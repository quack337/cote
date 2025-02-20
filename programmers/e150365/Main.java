package programmers.e150365;

public class Main {

    static class Solution {

        void addMoves(StringBuilder builder, char move, int count) {
            for (int i = 0; i < count; ++i)
                builder.append(move);
        }

        public String solution(int R, int C, int rS, int cS, int rE, int cE, int k) {
            int r = rS, c = cS;
            if (Math.abs(r - rE) + Math.abs(c - cE) > k) return "impossible";
            if ((k - (Math.abs(r - rE) + Math.abs(c - cE))) % 2 == 1) return "impossible";

            var moves = new StringBuilder();
            while (Math.abs(r - rE) + Math.abs(c - cE) + moves.length() < k) {
                //System.out.printf("%d %d\n", r, c);
                if (r < R) { moves.append('d'); ++r; }
                else if (c > 1) { moves.append('l'); --c; }
                else if (c < C) { moves.append('r'); ++c; }
                else if (r > 1) { moves.append('u'); --r; }
            }
            if (r < rE) addMoves(moves, 'd', rE - r);
            if (c > cE) addMoves(moves, 'l', c - cE);
            if (c < cE) addMoves(moves, 'r', cE - c);
            if (r > rE) addMoves(moves, 'u', r - rE);
            return moves.toString();
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(sol.solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(sol.solution(3, 3, 1, 2, 3, 3, 4));
    }

}
