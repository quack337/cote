package baekjoon.b2108;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int 합계(int[] a) {
        int result = 0;
        for (int i : a)
            result += i;
        return result;
    }

    static int 최빈값(int[] a) {
        int[] count = new int[8001];
        for (int i : a)
            count[i + 4000]++;
        int max = 1;
        ArrayList<Integer> maxValues = new ArrayList<>();
        for (int i = 0; i < count.length; ++i)
            if (count[i] > max) {
                maxValues.clear();
                maxValues.add(i - 4000);
                max = count[i];
            } else if (count[i] == max)
                maxValues.add(i - 4000);
        Collections.sort(maxValues);
        return maxValues.size() == 1 ? maxValues.get(0) : maxValues.get(1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; ++i)
            a[i] = Integer.parseInt(reader.readLine());
        int average = (int)Math.round(합계(a) * 1.0 / a.length);
        System.out.println(average);
        Arrays.sort(a);
        System.out.println(a[a.length/2]);
        System.out.println(최빈값(a));
        System.out.println(a[a.length - 1] - a[0]);
    }
}