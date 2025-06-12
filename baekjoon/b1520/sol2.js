// DP
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let DP = Array(ROW).fill().map(() => Array(COL).fill(-1));
DP[ROW-1][COL-1] = 1;
console.log(경로수(0,0));

function 경로수(r, c) {
  if (DP[r][c] > -1) return DP[r][c];
  let sum = 0;
  if (r > 0 && A[r-1][c] < A[r][c]) sum += 경로수(r-1, c);
  if (c > 0 && A[r][c-1] < A[r][c]) sum += 경로수(r, c-1);
  if (r < ROW-1 && A[r+1][c] < A[r][c]) sum += 경로수(r+1, c);
  if (c < COL-1 && A[r][c+1] < A[r][c]) sum += 경로수(r, c+1);
  return DP[r][c] = sum;
}
