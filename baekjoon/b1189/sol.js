// 답
let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => data[idx++], getInt = () => +data[idx++];
let ROW = getInt(), COL = getInt(), K = getInt(), A = [];
for (let i = 0; i < ROW; ++i)
  A[i] = getStr().split('');
let visited = A.map(() => Array(COL).fill(false)), 답 = 0;
DFS(ROW-1, 0, 1);
console.log(답);

function DFS(r, c, 거리) {
  if (A[r][c] == 'T' || visited[r][c]) return;
  visited[r][c] = true;
  if (r==0 && c==COL-1 && 거리==K) ++답;
  if (r > 0) DFS(r-1, c, 거리+1);
  if (c > 0) DFS(r, c-1, 거리+1);
  if (r < ROW-1) DFS(r+1, c, 거리+1);
  if (c < COL-1) DFS(r, c+1, 거리+1);
  visited[r][c] = false;
}
