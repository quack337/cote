// 답, 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let T = getInt();
let 빈칸 = 0, 배추 = 1, VISITED = -1;
let A, ROW, COL, K;
for (let t = 0; t < T; ++t) {
  COL = getInt(); ROW = getInt(); K = getInt();
  A = Array(ROW).fill().map(() => Array(COL).fill(빈칸));
  for (let i = 0; i < K; ++i) {
    let c = getInt(), r = getInt();
    A[r][c] = 배추;
  }
  let answer = 0;
  for (let r = 0; r < ROW; ++r)
    for (let c  = 0; c < COL; ++c)
      if (A[r][c] == 배추) {
        ++answer;
        DFS(r, c);
      }
  console.log(answer);
}

function DFS(r, c) {
  if (A[r][c] != 배추) return 0;
  A[r][c] = VISITED;
  if (r > 0) DFS(r-1, c);
  if (c > 0) DFS(r, c-1);
  if (r < ROW-1) DFS(r+1, c);
  if (c < COL-1) DFS(r, c+1);
}
