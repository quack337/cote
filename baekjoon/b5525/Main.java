package baekjoon.b5525;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  @SuppressWarnings("unused")
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    int M = Integer.parseInt(reader.readLine());
    char[] S = reader.readLine().toCharArray();
    int state = 0, 길이 = 0, 답 = 0;
    int[][] automata = {{2, 4, 2, 4, 2},{1, 1, 1, 1, 3}};
    for (int i = 0; i < S.length; ++i) {
      int ch = (S[i] == 'O' ? 0 : 1);
      int nextState = automata[ch][state];
      if (state == 1 && nextState == 4) 길이 = 0; // Ia -> Ob
      else if (state == 4 && nextState == 3) { // Ob -> Ib
        ++길이;
        if (길이 >= N) ++답;
      }
      state = nextState;
    }
    System.out.println(답);
  }
}