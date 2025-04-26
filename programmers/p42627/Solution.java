public class Solution {
  public int solution(int[][] jobs) {
    java.util.Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    var queue = new java.util.PriorityQueue<int[]>((a, b) ->
      a[2] != b[2] ? a[2] - b[2] : a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
    int i = 0, end = -1, answer = 0;
    for (int t = 0; i < jobs.length || queue.size() > 0; ++t) {
      while (i < jobs.length && t == jobs[i][0]) {
        queue.add(new int[] {i, jobs[i][0], jobs[i][1]});
        ++i;
      }
      boolean working = (end != -1 && t < end);
      if (!working && queue.size() > 0) {
        var job = queue.remove();
        end = t + job[2];
        answer += end - job[1];
        //System.out.printf(" %d [%d %d] %d\n", end, job[1], job[2], answer);  
      }
    }
    return answer / jobs.length;
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(new int[][] {{0,3},{1,9},{3,5}}));
    System.out.println(sol.solution(new int[][] {{0,3},{1,9},{2,6}}));
    System.out.println(sol.solution(new int[][] {{1,5},{10,20},{10,9},{10,10}}));
  }
}