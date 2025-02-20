package net.skhu.ebay2019;

public class Ex3b {
    static int[] a;
    static int index = 0;

    static void createTree() throws Exception {
        if (index >= a.length) throw new Exception();
        int value = a[index++];
        if (value != -1) {
           createTree();
           createTree();
        }
    }

    static boolean solution(int[] A) {
        try {
            a = A;
            index = 0;
            createTree();
            return index == a.length;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {-1}));
        System.out.println(solution(new int[] {3,5,6,8, -1,-1,-1, 1,7, -1,-1,-1, 4, -1, 2, -1,-1}));
        System.out.println(solution(new int[] {1, -1, 2, -1, -1, 3, -1, -1}));
        System.out.println(solution(new int[] {1, -1, 2, -1}));
    }
}