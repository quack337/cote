package baekjoon.b11004;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static void dualPivotPartition(int[] a, int start, int end, int[] pivot) {
        int size = end - start + 1;
        swap(a, start, start + size/3); // 3분의1 지점의 값이 기준값1
        swap(a, end, end - size/3);     // 3분의2 지점의 값이 기준값2
        if (a[start] > a[end]) swap(a, start, end);
        int lt = start + 1, gt = end - 1;
        int i = start + 1;
        while (i <= gt) {
            if (a[i] < a[start]) swap(a, lt++, i++);
            else if (a[end] <= a[i]) swap(a, i, gt--);
            else i++;
        }
        swap(a, start, --lt);
        swap(a, end, ++gt);
        pivot[0] = lt; // 기준값1의 위치
        pivot[1] = gt; // 기준값2의 위치
    }

    static int select(int[] A, int start, int end, int nth) {
        int[] pivot = new int[2];
        while (start < end) {
            dualPivotPartition(A, start, end, pivot);
            int pivot1_nth = pivot[0] - start + 1;
            int pivot2_nth = pivot[1] - start + 1;
            if (nth < pivot1_nth)
                end = pivot[0] - 1;
            else if (nth == pivot1_nth) return A[pivot[0]];
            else if (nth > pivot1_nth && nth < pivot2_nth) {
                start = pivot[0] + 1;
                end = pivot[1] - 1;
                nth = nth - pivot1_nth;
            }
            else if (nth == pivot2_nth) return A[pivot[1]];
            else {
                start = pivot[1] + 1;
                nth = nth - pivot2_nth;
            }
        }
        return A[start];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(select(A, 0, A.length-1, K));
    }
}