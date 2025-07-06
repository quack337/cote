package baekjoon.b15658;
import java.io.*;
import java.util.*;

public class Main {
  static final int 덧셈 = 0, 뺄셈 = 1, 곱셈 = 2, 나눗셈 = 3;
  static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
  static int[] A, OP;
  static List<Integer> selected = new ArrayList<Integer>();
  static int[] selectCount = new int[4];

  static void DFS() {
    if (selected.size() == N-1) {
      int value = A[0];
      for (int i = 0; i < N-1; ++i) {
        switch (selected.get(i)) {
        case 덧셈: value += A[i+1]; break;
        case 뺄셈: value -= A[i+1]; break;
        case 곱셈: value *= A[i+1]; break;
        case 나눗셈: value /= A[i+1]; break;
        }
      }
      if (value > max) max = value;
      if (value < min) min = value;
      return;
    }
    for (int i = 0; i < 4; ++i)
      if (selectCount[i] < OP[i]) {
        selected.add(i); selectCount[i]++;
        DFS();
        selected.remove(selected.size() - 1); selectCount[i]--;
      }
  }

  public static void main(String[] args) throws IOException {
   var wr = new BufferedWriter(new OutputStreamWriter(System.out));
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    OP = new int[4];
    for (int i = 0; i < 4; ++i) {
      tk.nextToken(); OP[i] = (int)tk.nval;
    }
    DFS();
    wr.write(max + "\n" + min + "\n");
    wr.close();
  }
}