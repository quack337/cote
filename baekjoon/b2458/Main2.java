package baekjoon.b2458;
import java.io.*;
import java.util.*;

// 통과: 메모리 198,644kb, 시간 1164ms
public class Main2 {
  static int N, E;
  static int[] A;
  static IntArray[] 작다, 크다;

  static class IntArray {
    int[] a;
    int count;

    public IntArray(int size) { a = new int[size]; }
    public int get(int i) { return a[i]; }
    public int size() { return count; }
    public void add(int val) {
      if (count == a.length) a = Arrays.copyOf(a, count * 2);
      a[count++] = val;
    }
    public void push(int val) { add(val); }
    public int pop() { return a[--count]; }
  }

  static int DFS(int start, IntArray[] neighbors) {
    int size = 0;
    var visited = new boolean[N+1];
    var stack = new IntArray(32);
    stack.push(start);
    while (stack.size() > 0) {
      int node = stack.pop();
      if (visited[node]) continue;
      visited[node] = true;
      ++size;
      for (int i = 0; i < neighbors[node].count; ++i)
        stack.push(neighbors[node].get(i));
    }
    return size;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    작다 = new IntArray[N+1];
    크다 = new IntArray[N+1];
    for (int i = 1; i <= N; ++i) {
      작다[i] = new IntArray(4);
      크다[i] = new IntArray(4);
    }
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      크다[a].add(b);
      작다[b].add(a);
    }
    scanner.close();
    int answer = 0;
    for (int node = 1; node <= N; ++node)
      if (DFS(node, 작다) + DFS(node, 크다) == N+1)
        ++answer;
    System.out.println(answer);
  }
}