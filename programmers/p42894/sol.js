function solution(rowCount, colCount, puddles) {
  let DP = Array(rowCount+1).fill().map(() => Array(colCount+1).fill(0));
  let 홍수 = Array(rowCount+1).fill().map(() => Array(colCount+1).fill(false));
  puddles.forEach(p => 홍수[p[0]][p[1]] = true);
  DP[1][0] = 1;
  for (let r = 1; r <= rowCount; ++r)
    for (let c = 1; c <= colCount; ++c)
      if (!홍수[r][c])
        DP[r][c] = (DP[r - 1][c] + DP[r][c - 1]) % 1_000_000_007;
  return DP[rowCount][colCount];
}

console.log(solution(4, 3, [[2,2]]));
