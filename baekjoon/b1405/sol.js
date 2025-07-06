let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => data[idx++], getInt = () => +data[idx++];
let N = getInt(), A = [];
for (let i = 0; i < 4; ++i)
  A[i] = getInt() / 100;
const D = [[0,1],[0,-1],[1,0],[-1,0]];
let selected = [], visited = Array(N*2+1).fill().map(() => []), 답 = 0;
visited[N][N] = true;
DFS(N, N);
console.log(답);

function DFS(r, c) {
  if (selected.length == N) {
    let 확률 = selected.reduce((r,e) => r * A[e], 1);
    답 += 확률;
    return;
  }
  for (let i = 0; i < 4; ++i) {
    let r2 = r + D[i][0], c2 = c + D[i][1];
    if (!visited[r2][c2]) {
      selected.push(i);
      visited[r2][c2] = true;
      DFS(r2, c2);
      selected.pop();
      visited[r2][c2] = false;
    }
  }
}
