package etcc.cote2023;
import java.util.Arrays;

public class Example2 {

    // 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // bubble sort
    static void bubbleSort(int[] a) {
        int count = 0;
        for (int i = a.length - 1; i >= 1; --i) {
            boolean 완료 = true; // (가)
            for (int j = 0; j < i; ++j) {
                ++count;
                if (a[j] > a[j + 1]) {  // (나)
                    swap(a, j, j + 1);
                    완료 = false;   // (다)
                }
            }
            if (완료) break; // (라)
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] a1 = { 11, 13, 12, 14, 15, 16, 17, 18, 19, 20 };
        int[] a2 = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
        int[] a3 = { 17, 14, 11, 19, 13, 15, 20, 12, 16, 18 };

        bubbleSort(a1);
        bubbleSort(a2);
        bubbleSort(a3);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }
}