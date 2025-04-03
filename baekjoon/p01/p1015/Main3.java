package baekjoon.p01.p1015;

public class Main3 {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void 삽입정렬(int[] A, int[] Q) {
        for (int i = 1; i < A.length; ++i) {
            int value = A[i];             // 삽입할 값 보관
            int j;
            for (j = i - 1; j >= 0; --j)  // 뒤로 이동
                if (A[j] > value) {
                    A[j + 1] = A[j];
                    Q[j + 1] = Q[j];
                }
                else
                    break;
            A[j + 1] = value;             // 값 삽입
            Q[j + 1] = i;
        }
    }


    static void 테스트(int[] a) {
        int N = a.length;
        int[] A = new int[N];
        int[] Q = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = a[i];
            Q[i] = i;
        }
        삽입정렬(A, Q);
        int[] P = new int[N];
        for (int i = 0; i < N; ++i)
            P[Q[i]] = i;
        for (int i : P)
            System.out.printf("%d ", i);
        System.out.println();
    }

    public static void main(String[] args) {
        테스트(new int[] { 2, 3, 1 });    // 1 2 0
        테스트(new int[] { 1, 2, 3, 4 }); // 0 1 2 3
        테스트(new int[] { 1, 1, 2, 2, 2  }); // 0 1 2 3 4
        테스트(new int[] { 2, 2, 1, 1, 1  }); // 3 4 0 1 2
        테스트(new int[] { 1, 3, 2, 5, 4  }); // 0 2 1 4 3
        테스트(new int[] { 1, 3, 3, 2, 2  }); // 0 3 4 1 2
    }
}