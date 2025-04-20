package baekjoon.b11004;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void countingSort(int[] arr, int start, int end, int nth) {
        int[] count = new int[256];
        for (int i = start; i <= end; ++i) {
            int value = arr[i];
            int digit = value >> (nth * 8) & 0xFF;
            ++count[digit];
        }
        int[] index = new int[256];
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];
        int[] temp = new int[end - start + 1];
        for (int i = start; i <= end; ++i) {
            int value = arr[i];
            int digit = value >> (nth * 8) & 0xFF;
            temp[index[digit]++] = value;
        }
        for (int i = start; i <= end; ++i)
            arr[i] = temp[i - start];
    }

    static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
    public static int partitionBy0(int[] arr) {
      int i = -1;
      for (int j = 0; j < arr.length; ++j)
          if (arr[j] < 0)
              swap(arr, ++i, j);
      return i + 1;
  }

    public static void radixSort(int[] arr) {
        int middle = partitionBy0(arr);
        for (int i = 0; i < 4; ++i) {
            countingSort(arr, 0, middle - 1, i);
            countingSort(arr, middle, arr.length - 1, i);
        }
    }

    static int select(int[] arr, int k) {
        radixSort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(select(arr, k));
    }
}