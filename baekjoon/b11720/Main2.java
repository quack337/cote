package baekjoon.b11720;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    String s = reader.readLine();
    for (char ch : s.toCharArray())
      System.out.println((int)ch - '0');
    reader.close();
  }
}