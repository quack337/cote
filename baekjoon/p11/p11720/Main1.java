package baekjoon.p11.p11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1 {

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    String s = reader.readLine();
    for (char ch : s.toCharArray())
      System.out.println((int)ch);
    reader.close();
  }
}