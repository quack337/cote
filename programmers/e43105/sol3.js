function solution(dp) {
  for (let r = dp.length - 2; r >= 0; --r)
    for (let c = 0; c < dp[r].length; ++c) {
      let a = dp[r+1][c], b = dp[r+1][c+1];
      dp[r][c] += a > b ? a : b;
    }
  return dp[0][0];
}

console.log(solution([[7],[3,8],[8,1,0],[2,7,4,4],[4,5,2,6,5]]));