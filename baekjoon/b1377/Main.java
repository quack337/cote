package baekjoon.b1377;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    int[][] A = new int[N][2];
    for (int i = 0; i < N; ++i) {
        A[i][0] = Integer.parseInt(reader.readLine());
        A[i][1] = i;
    }
    Arrays.sort(A, (a, b) -> a[0] - b[0]);
    int answer = 0;
    for (int i = 0; i < N; ++i)
      answer = Math.max(A[i][1] - i, answer);
    System.out.println(answer + 1);
    reader.close();
  }
}