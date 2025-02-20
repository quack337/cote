package programmers.e388352;

public class Main1 {

  static class Solution {
      int[][] DP = new int[31][31]; // nCr 값 계산 동적 계획법

      int nCr(int n, int r) { // nCr 값 계산
          if (r < 0 || r > n) return 0;
          if (r == 0 || r == n) return 1;
          if (DP[n][r] > 0) return DP[n][r];
          return DP[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r);
      }

      int get조합개수(int qindex1, int qindex2, int 남은선택, int[][] q, int[] ans, int[] 선택상태) {
          if (qindex2 >= 5) { // q[qindex1]의 5개 정수 선택이 완료됨
              if (qindex1 == q.length - 1) { // q, ans를 만족하는 선택 조합들 중 하나 완성

                  // 선택상태가 0인 것과, 1인 것의 수를 센다
                  int[] count = new int[2];
                  for (int i = 1; i < 선택상태.length; ++i)
                      if (선택상태[i] >= 0) ++count[선택상태[i]];

                  // count[1] 개의 정수를 선택했으니, 선택 가능한 count[0]개의 수 중에서
                  // 5 - count[1] 개의 정수를 더 선택해야 한다
                  return nCr(count[0], 5 - count[1]);
              }
               // 다음 단계 재귀 호출
              return get조합개수(qindex1 + 1, 0, ans[qindex1 + 1], q, ans, 선택상태);
          }
          int 정수 = q[qindex1][qindex2]; // 현재 단계에서 선택/비선택 둘 다 시도해 볼 정수
          int 백업 = 선택상태[정수]; // 이 정수의 이전 선택상태 백업
          int 조합개수 = 0; // 리턴할 값

          // 그 정수를 선택하지 않는 시도
          int 남은수 = 5 - qindex2;
          if (남은수 > 남은선택) { // 남은 정수들의 개수가 선택해야할 개수 보다 클 때만,
                                  // 이 정수를 선택 안 하는 시도가 가능하다
              if (선택상태[정수] != 1) { // 이미 선택한 정수가 아닌 경우에만,
                  선택상태[정수] = -1;   // 이 정수를 선택하지 않는 시도가 가능
                  조합개수 += get조합개수(qindex1, qindex2 + 1, 남은선택, q, ans, 선택상태);
                  선택상태[정수] = 백업; // 이 정수의 이전 선택상태 복구
              }
          }
          // 그 정수를 선택하는 시도
          if (남은선택 > 0) {
              if (선택상태[정수] != -1) { // 이미 선택하지 않기로한 정수라면 선택하는 시도 불가능
                  선택상태[정수] = 1;     // 그 수를 선택하는 시도
                  조합개수 += get조합개수(qindex1, qindex2 + 1, 남은선택 - 1, q, ans, 선택상태);
                  선택상태[정수] = 백업; // 이 정수의 이전 선택상태 복구
              }
          }
          return 조합개수;
      }

      public int solution(int n, int[][] q, int[] ans) {
          return get조합개수(0, 0, ans[0], q, ans, new int[n + 1]);
      }
  }

  public static void main(String[] args) {
      int n = 10;
      int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10},
                      {3, 4, 5, 6, 7}};
      int[] ans = {2, 3, 4, 3, 3};
      int answer = (new Solution()).solution(n, q, ans);
      System.out.println(answer);

      n = 15;
      q = new int[][] {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15},
                           {1, 4, 10, 11, 14}};
      ans = new int[] {2, 1, 3, 0, 1};
      answer = (new Solution()).solution(n, q, ans);
      System.out.println(answer);
  }
}
