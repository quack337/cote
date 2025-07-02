package baekjoon.b1062;
import java.io.*;
import java.util.*;

// 답 비트연산 사용
public class Main2 {
  static char[] ALPHA1 = "antic".toCharArray();
  static char[] ALPHA2 = "bdefghjklmopqrsuvwxyz".toCharArray();
  static int N = ALPHA2.length, R, answer = 0;
  static int[] words;
  static int selected = 0, selectCount = 0;

  static void DFS(int from, int to) throws IOException {
    if (selectCount == R) {
      int count = 0;
      for (var word : words)
        if ((word & ~selected) == 0) ++count;
      if (count > answer) answer = count;
      return;
    }
    for (int i = from; i <= to; ++i) {
      selected |= (1 << i); ++selectCount;
      DFS(i + 1, to + 1);
      selected &= ~(1 << i); --selectCount;
    }
  }

  static void printWord(int word, String sp) {
    for (int i = 0; i < ALPHA2.length; ++i)
      if ((word & (1 << i)) > 0)
        System.out.print(ALPHA2[i]);
    System.out.print(sp);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(rd.readLine());
    int n = Integer.parseInt(tk.nextToken());
    int K = Integer.parseInt(tk.nextToken());
    R = K - ALPHA1.length;
    words = new int[n];
    for (int i = 0; i < n; ++i) {
      String w = rd.readLine();
      for (char ch : w.toCharArray()) {
        int index = Arrays.binarySearch(ALPHA2, ch);
        if (index >= 0) words[i] |= (1 << index);
      }
    }
    if (R >= 0) DFS(0, N-R);
    System.out.println(answer);
  }
}
