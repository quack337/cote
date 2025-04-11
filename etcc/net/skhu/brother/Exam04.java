package etcc.net.skhu.brother;
public class Exam04 {

    static int 합(char[] a) {
        int result = 0;
        for (int c : a) result += (c - '0');
        return result;
    }

    static int 곱(char[] a) {
        int result = 1;
        for (int c : a) result *= (c - '0');
        return result;
    }

    static int 최대값(int page) {
        char[] a = String.valueOf(page).toCharArray();
        return Math.max(합(a), 곱(a));
    }

    static int 최대값(int[] pages) {
        return Math.max(최대값(pages[0]), 최대값(pages[1]));
    }

    static boolean isValid(int[] pages) {
        return pages[0] + 1 == pages[1];
    }

    public static int solution(int[] pobi, int[] crong) {
        if ((isValid(pobi) && isValid(crong)) == false) return -1;
        int max1 = 최대값(pobi);
        int max2 = 최대값(crong);
        if (max1 > max2) return 1;
        if (max1 < max2) return 2;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {97, 98}, new int[] {197, 198}));
        System.out.println(solution(new int[] {131, 132}, new int[] {211, 212}));
        System.out.println(solution(new int[] {99, 102}, new int[] {211, 212}));
    }
}