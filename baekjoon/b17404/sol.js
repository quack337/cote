let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A.shift()[0];
let M=Array(N).fill().map(_=>Array(3).fill().map(_=>[]));
let cost = Infinity;
for (let c=0; c<3; ++c)
  cost = Math.min(cost, DFS(1,c,c) + A[0][c]);
console.log(cost);

function DFS(n,cp,c0) {
  if (n==N) return 0;
  if (M[n][cp][c0] != undefined) return M[n][cp][c0];
  let cost = Infinity;
  for (let c=0; c<3; ++c) {
    if (c==cp || (c==c0 && n==N-1)) continue;
    cost = Math.min(cost, DFS(n+1,c,c0) + A[n][c]);
  }
  return M[n][cp][c0] = cost;
}