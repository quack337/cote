let IN = require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N = IN[0][0];
let A = IN.slice(1), M=Array(N).fill().map(_=>[]);
console.log(DFS(0,0)+'');

function DFS(r, c) {
  if (r>=N || c>=N) return 0n;
  if (M[r][c] != undefined) return M[r][c];
  if (r==N-1 && c==N-1) return M[r][c] = 1n;
  let j = A[r][c];
  if (j == 0) return M[r][c] = 0n;
  return M[r][c] = DFS(r+j, c) + DFS(r, c+j); 
}