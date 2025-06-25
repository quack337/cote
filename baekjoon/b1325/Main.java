package baekjoon.b1325;
import java.io.*;
import java.util.*;

public class Main {
  static IntArray[] neighbors;
  static boolean[] visited;
  static IntArray stack = new IntArray(8192);

  static class IntArray {
    int[] a;
    int count = 0;

    public IntArray(int size) { a = new int[size]; }
    public void add(int value) {
      if (count == a.length)
        a = Arrays.copyOf(a, a.length * 2);
      a[count++] = value;
    }

    public void push(int value) { add(value); }
    public int pop() { return a[--count]; }
    public int get(int i) { return a[i]; }
    public int size() { return count; }
  }

  static int 그래프크기(int start) {
    stack.count = 0;
    stack.push(start);
    int size = 0;
    while (stack.size() > 0) {
      int node = stack.pop();
      if (visited[node]) continue;
      visited[node] = true;
      ++size;
      if (neighbors[node] != null) {
        int end = neighbors[node].size();
        for (int i = 0; i < end; ++i) {
          int neighbor = neighbors[node].get(i);
          if (!visited[neighbor]) stack.push(neighbor);
        }
      }
    }
    return size;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int E = Integer.parseInt(tokenizer.nextToken());
    neighbors = new IntArray[N+1];
    for (int i = 0; i < E; ++i) {
        tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        if (neighbors[b] == null) neighbors[b] = new IntArray(8);
        neighbors[b].add(a);
    }
    reader.close();
    int maxSize = 0;
    int[] sizes = new int[N+1];
    visited = new boolean[N+1];
    for (int node = 1; node <= N; ++node) {
      Arrays.fill(visited, false);
      sizes[node] = 그래프크기(node);
      if (sizes[node] > maxSize) maxSize = sizes[node];
    }
    var builder = new StringBuilder();
    for (int node = 1; node <= N; ++node)
      if (sizes[node] == maxSize)
        builder.append(node).append(' ');
    System.out.println(builder.toString());
  }
}