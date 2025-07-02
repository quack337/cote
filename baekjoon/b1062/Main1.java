package baekjoon.b1062;
import java.io.*;
import java.util.*;

// 답 Set 사용
public class Main1 {
  static String ALPHA1 = "antic";
  static char[] ALPHA2 = "bdefghjklmopqrsuvwxyz".toCharArray();
  static int N = ALPHA2.length, R, answer = 0;
  static Set<Character>[] words;
  static List<Integer> selected = new ArrayList<>();

  static boolean canRead(Set<Character> word) {
    int count = 0;
    for (int i : selected)
      if (word.contains(ALPHA2[i])) ++count;
    return count == word.size();
  }

  static void DFS(int from, int to) throws IOException {
    if (selected.size() == R) {
      int count = 0;
      for (var word : words)
        if (canRead(word)) ++count;
      if (count > answer) answer = count;
      return;
    }
    for (int i = from; i <= to; ++i) {
      selected.add(i);
      DFS(i + 1, to + 1);
      selected.remove(selected.size() - 1);
    }
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws NumberFormatException, IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(rd.readLine());
    int n = Integer.parseInt(tk.nextToken());
    int K = Integer.parseInt(tk.nextToken());
    R = K - ALPHA1.length();
    words = new HashSet[n];
    for (int i = 0; i < n; ++i) {
      String w = rd.readLine();
      words[i] = new HashSet<>();
      for (char ch : w.toCharArray())
        if (ALPHA1.indexOf(ch) < 0)
          words[i].add(ch);
    }
    if (R >= 0) DFS(0, N-R);
    System.out.println(answer);
  }
}
