package baekjoon.b11720;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3 {

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    String s = reader.readLine();
    int sum = 0;
    for (char ch : s.toCharArray())
      sum += (int)ch - '0';
    System.out.println(sum);
    reader.close();
  }
}