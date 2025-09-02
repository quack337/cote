let IN = require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let [R, C] = IN.shift();
let A = IN;
let M = Array(R).fill().map(_=>Array(C).fill(-1));
console.log(DFS(0, 0));

function DFS(r, c) {
  if (r==R || c==C) return 0;
  if (M[r][c]>-1) return M[r][c];
  return M[r][c] = Math.max(DFS(r+1, c), DFS(r, c+1), DFS(r+1, c+1)) + A[r][c];
}