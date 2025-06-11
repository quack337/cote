// 답, 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let 땅 = 1, A, ROW, COL, visited, answer = [];
const MV = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]];

while (true) {
  COL = getInt(); ROW = getInt();
  if (COL == 0 && ROW == 0) break;
  A = Array(ROW).fill().map(() => []);
  for (let r = 0; r < ROW; ++r)
    for (let c = 0; c < COL; ++c)
      A[r][c] = getInt();
  answer.push(연결그래프수());
}
console.log(answer.join('\n'));

function 연결그래프수() {
  let count = 0;
  visited = Array(ROW).fill().map(() => []);
  for (let r = 0; r < ROW; ++r)
    for (let c  = 0; c < COL; ++c)
      if (!visited[r][c] && A[r][c] == 땅) {
        ++count;
        DFS(r, c);
      }
  return count;
}

function DFS(r, c) {
  if (visited[r][c] || A[r][c] != 땅) return;
  visited[r][c] = true;
  for (let mv of MV) {
    let rr = r + mv[0], cc = c + mv[1];
    if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
    DFS(rr, cc);
  }
}
