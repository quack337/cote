public class Main1 {
  public static void main(String[] args) {
    var sol = new Solution();
    var grid = new int[][] {{-1,-1,-1},{1,1,-1},{1,1,1}};
    System.out.println(sol.solution(grid));
    grid = new int[][] {{1,-1,1},{-1,1,-1}};
    System.out.println(sol.solution(grid));
    grid = new int[][] {{1}};
    System.out.println(sol.solution(grid));
  }
}

class Solution {
  int[][][] V;
  int[][] G;
  int id, R, C;

  int dfs(int r, int c, int e) {
    int x=1, g=G[r][c];
    if (V[r][c][e<0?0:1]==id || V[r][c][e<0?1:0] == id) return 0;
    V[r][c][e<0?0:1]=id;
    if (e==-1 && r>0) x += dfs(r-1,c,1);
    if (e==1 && r<R-1) x += dfs(r+1,c,-1);
    if (e==g && c<C-1) x += dfs(r,c+1, G[r][c+1]*-1);
    if (e!=g && c>0) x += dfs(r,c-1, G[r][c-1]);
    return x;
  }

  public int solution(int[][] grid) {
    G=grid; R=G.length; C=G[0].length;
    int x=0;
    id=0;
    V=new int[R][C][2];
    for (int r=0;r<R;++r)
    for (int c=0;c<C;++c)
    for (int e=0;e<2;++e)
      if (V[r][c][e] == 0) {
        ++id;
        x = Math.max(x, dfs(r,c,e==1?1:-1));
      }
    return x;
  }
}
