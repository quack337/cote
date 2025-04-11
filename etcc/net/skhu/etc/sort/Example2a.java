package etcc.net.skhu.etc.sort;
import java.util.Arrays;

public class Example2a {

    static void sort(char[] a) {
        Arrays.sort(a); // O(N logN)
    }

    public static void main(String[] args) {
        char[] a = "hello world!".toCharArray();
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}