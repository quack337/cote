let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), ix = 0;
let R = +data[ix++], C = +data[ix++], K = +data[ix++], A = [];
for (let i = 0; i < R; ++i)
  A[i] = data[ix++].split('');
let path = A.map(() => []), 답 = 0;
DFS(R-1, 0, 1);
console.log(답);

function DFS(r, c, 거리) {
  if (A[r][c] == 'T' || path[r][c]) return;
  path[r][c] = true;
  if (r==0 && c==C-1 && 거리==K) ++답;
  if (r > 0) DFS(r-1, c, 거리+1);
  if (c > 0) DFS(r, c-1, 거리+1);
  if (r < R-1) DFS(r+1, c, 거리+1);
  if (c < C-1) DFS(r, c+1, 거리+1);
  path[r][c] = false;
}
