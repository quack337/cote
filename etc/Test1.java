import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test1 {

  static void input1() throws IOException {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine();
    var tokennizer = new StringTokenizer(s);
    int N = Integer.parseInt(tokennizer.nextToken());;
    int M = Integer.parseInt(tokennizer.nextToken());;
  }

  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    int[] A = new int[N];
    String s = reader.readLine();
    var tokennizer = new StringTokenizer(s);
    for (int i = 0; i < N; ++i)
        A[i] = Integer.parseInt(tokennizer.nextToken());

    reader.close();

    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    writer.close();
  }
}
