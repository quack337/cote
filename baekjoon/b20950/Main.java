package baekjoon.b20950;
import java.io.*;
import java.util.*;

public class Main {
  static int N, answer = Integer.MAX_VALUE;
  static int[][] colors;
  static int[] rgbGom = new int[3];

  // index: index 위치의 색을 선택하고/선택하지 않고 재귀호출 시도한다
  // count: 지금까지 선택한 색의 수
  // redSum: 지금까지 선택한 색의 red 값 누적 합계
  // greenSum: 지금까지 선택한 색의 green 값 누적 합계
  // blueSum: 지금까지 선택한 색의 blue 값 누적 합계
  static void dfs(int index, int count, int redSum, int greenSum, int blueSum) {
    if (count > 7) return;   // 선택 갯수 초과 컷
    if (N - index + count < 2) return; // 선택 갯수 미만 컷
    if (count == 7 || index == N) { // 선택 갯수가 이미 MAX 이거나 || 리프 노드에 도착했으면
      if (count >= 2) {
        int diff = calc(count, redSum, greenSum, blueSum); // 색 차이를 계산한다
        if (diff < answer) answer = diff; // 색 차이의 최소값을 찾는다
      }
      return;
    }

    // index 위치의 색을 선택하고 재귀호출
    dfs(index + 1, count + 1,
      redSum + colors[index][0],
      greenSum + colors[index][1],
      blueSum + colors[index][2]);

    // index 위치의 색을 선택하지 않고 재귀호출
    dfs(index + 1, count, redSum, greenSum, blueSum);
  }

  static int calc(int count, int redSum, int greenSum, int blueSum) {
    int[] rgb = {redSum, greenSum, blueSum};
    int diff = 0;
    for (int i = 0; i < 3; i++) { // reg, green, blue에 대해서 반복한다
      int avg = rgb[i] / count; // 선택된 색의 평균
      diff += Math.abs(rgbGom[i] - avg); // 곰두리 색과의 차이
    }
    return diff;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    colors = new int[N][3];
    for (int i = 0; i < N; i++) {
      // 문제의 입력으로 주어진 rgb 색 목록
      st = new StringTokenizer(br.readLine());
      colors[i][0] = Integer.parseInt(st.nextToken());
      colors[i][1] = Integer.parseInt(st.nextToken());
      colors[i][2] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    // 문제의 입력으로 주어진 곰두리 색
    rgbGom[0] = Integer.parseInt(st.nextToken());
    rgbGom[1] = Integer.parseInt(st.nextToken());
    rgbGom[2] = Integer.parseInt(st.nextToken());

    dfs(0, 0, 0, 0, 0);
    System.out.println(answer);
  }
}
