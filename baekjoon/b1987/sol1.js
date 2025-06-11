// 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = [];
for (let r = 0; r < ROW; ++r)
  A[r] = getStr().split('');
let path = new Set();
let MV = [[-1,0],[1,0],[0,-1],[0,1]];
console.log(DFS(0, 0));

function DFS(r, c) {
  if (path.has(A[r][c])) return path.size;
  path.add(A[r][c]);
  let maxDepth = 0;
  for (let mv of MV) {
    let rr = r + mv[0], cc = c + mv[1];
    if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
    let depth = DFS(rr, cc);
    if (depth > maxDepth) maxDepth = depth;
  }
  path.delete(A[r][c]);
  return maxDepth;
}
