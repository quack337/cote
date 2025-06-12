// 재귀 stack
// 벽 그리기가 관건. 벽 그리기 테스트
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt(), K = getInt();
let 벽 = 1, 탐색할칸 = 0;
let A = Array(ROW).fill().map(() => Array(COL).fill(탐색할칸));
let visited = Array(ROW).fill().map(() => []);
for (let i = 0; i < K; ++i) {
  let c1 = getInt(), r1 = getInt(), c2 = getInt(), r2 = getInt();
  for (let r = r1; r < r2; ++r)
    for (let c = c1; c < c2; ++c)
      A[r][c] = 벽;
}
let sizes = [];
연결그래프탐색();
sizes.sort((a, b) => a - b);
console.log(sizes.length);
console.log(sizes.join(' '));

function 연결그래프탐색() {
  for (let r = 0; r < ROW; ++r)
    for (let c  = 0; c < COL; ++c)
      if (!visited[r][c] && A[r][c] == 탐색할칸)
        sizes.push(DFS(r, c));
}

function DFS(rStart, cStart) {
  let stack = [], size = 0;
  stack.push([rStart, cStart]);
  while (stack.length > 0) {
    let [r, c] = stack.pop();
    if (A[r][c] != 탐색할칸 || visited[r][c]) continue;
    visited[r][c] = true;
    ++size;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < ROW-1) stack.push([r+1, c]);
    if (c < ROW-1) stack.push([r, c+1]);
  }
  return size;
}
