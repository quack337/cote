package programmers.p150367;

import java.util.Arrays;

public class Main1 {

    static class Solution {

int getTreeSize(int length) {
    for (int i = 1; i <= 63; ++i) {
        int size = (1 << i) - 1;
        if (size >= length) return size;
    }
    return -1;
}

boolean solution(long number) {
    String s = Long.toBinaryString(number);
    int treeSize = getTreeSize(s.length());
    char[] tree = new char[treeSize];
    Arrays.fill(tree, '0');
    int paddingLength = treeSize - s.length();
    for (int i = paddingLength; i < tree.length; ++i)
        tree[i] = s.charAt(i - paddingLength);
    System.out.println(Arrays.toString(tree));
    return true;
}

        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];
            for (int i = 0; i < numbers.length; ++i)
                answer[i] = solution(numbers[i]) ? 1: 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var numbers = new long[] { 7, 42, 5, 63, 111, 95 };
        sol.solution(numbers);
    }
}