let IN = require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N = IN[0][0], Q = IN[2][0];
let A = IN[1];
let X = [], M=Array(N).fill().map(_=>[]);
for (let i=0; i < Q; ++i) {
  let [s, e] = IN[3+i];
  X.push(DFS(s-1, e-1) ? 1 : 0);
}
console.log(X.join('\n'));

function DFS(s,e) {
  if (s >= e) return true;
  if (M[s][e]!=undefined) return M[s][e];
  return M[s][e] = (A[s]==A[e] && DFS(s+1, e-1));
}
