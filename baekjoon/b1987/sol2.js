// 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = [];
for (let r = 0; r < ROW; ++r) {
  A[r] = getStr().split('');
  for (let c = 0; c < COL; ++c)
    A[r][c] = A[r][c].charCodeAt(0) - 'A'.charCodeAt(0);
}
let visited = [];
let MV = [[-1,0],[1,0],[0,-1],[0,1]];
console.log(DFS(0, 0));

function DFS(r, c) {
  let index = A[r][c];
  if (visited[index]) return 0;
  visited[index] = true;
  let maxDepth = 0;
  for (let mv of MV) {
    let rr = r + mv[0], cc = c + mv[1];
    if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
    let depth = DFS(rr, cc);
    if (depth > maxDepth) maxDepth = depth;
  }
  visited[index] = false;
  return maxDepth + 1;
}
