package baekjoon.b02.p2136;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static class Ant { int no, dir; long position, seconds; }
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int L = Integer.parseInt(tokenizer.nextToken());
    Ant[] ar = new Ant[N];
    for (int i = 0; i < N; ++i) {
      long p = Long.parseLong(reader.readLine());
      Ant ant = new Ant();
      ant.no = i + 1;
      ant.dir = p < 0 ? -1 : 1;
      ant.position = Math.abs(p);
      ant.seconds = ant.dir < 0 ? ant.position : L - ant.position;
      ar[i] = ant;
    }
    Ant[] ar1 = Arrays.copyOf(ar, ar.length);
    Arrays.sort(ar1, (a, b) -> {
      if (a.dir != b.dir) return a.dir - b.dir;
      return a.dir == -1 ? Long.compare(a.seconds, b.seconds) :
                           Long.compare(b.seconds, a.seconds);
    });
    long maxSeconds = 0; int maxIndex = 0;
    for (int i = 0; i < ar1.length; i++) {
      if (ar1[i].seconds > maxSeconds) {
        maxSeconds = ar1[i].seconds;
        maxIndex = i;
      }
    }
    Arrays.sort(ar, (a, b) -> Long.compare(a.position, b.position));
    System.out.println(ar[maxIndex].no + " " + maxSeconds);
  }
}