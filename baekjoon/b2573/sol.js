let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = Array(ROW).fill().map(() => []);
let visited;
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
for (let i = 1; true; ++i) {
  melt();
  let count = 연결그래프의수();
  if (count > 1) { console.log(i); break; }
  else if (count == 0) { console.log(0); break; }
}

function melt() {
  let B = Array(ROW).fill().map(() => []);
  for (let r = 0; r < ROW; ++r)
    for (let c = 0; c < COL; ++c) {
      B[r][c] = A[r][c];
      if (r > 0 && A[r-1][c] == 0) --B[r][c];
      if (c > 0 && A[r][c-1] == 0) --B[r][c];
      if (r < ROW-1 && A[r+1][c] == 0) --B[r][c];
      if (c < COL-1 && A[r][c+1] == 0) --B[r][c];
      if (B[r][c] < 0) B[r][c] = 0;
    }
    A = B;
}

function 연결그래프의수() {
  let count = 0;
  visited = Array(ROW).fill().map(() => []);
  for (let r = 0; r < ROW; ++r)
    for (let c = 0; c < COL; ++c)
      if (A[r][c] > 0 && !visited[r][c]) {
        DFS(r, c);
        ++count;
      }
  return count;
 }

function DFS(r, c) {
  if (visited[r][c] || A[r][c] == 0) return;
  visited[r][c] = true;
  if (r > 0) DFS(r-1, c);
  if (c > 0) DFS(r, c-1);
  if (r < ROW-1) DFS(r+1, c);
  if (c < COL-1) DFS(r, c+1);
}