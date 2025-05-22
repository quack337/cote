package baekjoon;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int N = scanner.nextInt();;
    int[] A = new int[N];
    for (int i = 0; i < N; ++i)
      A[i] = scanner.nextInt();
    scanner.close();
  }
}