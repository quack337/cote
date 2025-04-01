function solution(triangle) {
  let DP = triangle.map(row => row.slice());
  for (let r = triangle.length - 2; r >= 0; --r)
    for (let c = 0; c < triangle[r].length; ++c)
      DP[r][c] += Math.max(DP[r+1][c], DP[r+1][c+1]);  
  return DP[0][0];
}

console.log(solution([[7],[3,8],[8,1,0],[2,7,4,4],[4,5,2,6,5]]));