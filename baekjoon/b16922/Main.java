package baekjoon.b16922;
import java.util.*;
import java.io.*;

public class Main {
  static int R;
  static int[] A = {1, 5, 10, 50}; // 1,5,10,50의 조합으로 로마 숫자를 만든다
  static Set<Integer> set = new HashSet<>(); // 로마숫자를 조합해서 만들어진 수의 집합.
                                             // 중복된 값이 자동으로 걸러진다
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    R = Integer.parseInt(br.readLine().trim());
    DFS(0, 0, 0);
    System.out.println(set.size()); // 답 출력
  }

  static void DFS(int from, int sum, int count) { // sum: 지금까지 선택한 수들의 합계,
                                                  // count: 지금까지 선택한 갯수
    if (count == R) set.add(sum); // R개를 선택했다면, 선택한 수들의 합계를 set에 추가하고 리턴한다
    else {
      for (int i = from; i < A.length; ++i) // 아직 R개를 선택하지 않았다면
        DFS(i, sum + A[i], count + 1); // A[i] 수를 선택하고 재귀호출
    }
  }
}
