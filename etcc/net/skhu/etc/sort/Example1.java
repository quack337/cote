package etcc.net.skhu.etc.sort;
import java.util.Arrays;

public class Example1 {

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void partition(int[] a) {
        int j = -1;
        for (int i = 0; i < a.length - 1; ++i)
            if (a[i] % 2 == 0)
                swap(a, ++j, i);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        partition(a);
        System.out.println(Arrays.toString(a));
    }
}