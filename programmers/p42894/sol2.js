function solution(rowCount, colCount, puddles) {
  let DP = [], 홍수 = [];
  for (let r = 0; r <= rowCount; ++r) {
    DP[r] = Array(colCount+1).fill(0);
    홍수[r] = Array(colCount+1).fill(false);
  }
  for (let p of puddles) 홍수[p[0]][p[1]] = true;
  DP[1][0] = 1;
  for (let r = 1; r <= rowCount; ++r)
    for (let c = 1; c <= colCount; ++c)
      if (!홍수[r][c])
        DP[r][c] = (DP[r - 1][c] + DP[r][c - 1]) % 1_000_000_007;
  return DP[rowCount][colCount];
}

console.log(solution(4, 3, [[2,2]]));
