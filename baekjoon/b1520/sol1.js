// 시간초과
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = Array(ROW).fill().map(() => []);
let visited = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let count = 0;
DFS(0, 0);
console.log(count);

function DFS(r, c, prev) {
  if (visited[r][c] || A[r][c] >= prev) return;
  visited[r][c] = true;
  if (r == ROW-1 && c == COL-1) ++count;
  if (r > 0) DFS(r - 1, c, A[r][c]);
  if (c > 0) DFS(r, c - 1, A[r][c]);
  if (r < ROW-1) DFS(r + 1, c, A[r][c]);
  if (c < COL-1) DFS(r, c + 1, A[r][c]);
  visited[r][c] = false;
}
