let IN = require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N = IN[0][0];
let A = IN.slice(1), M = Array(N).fill().map(_=>[]);
console.log(DFS(0,N-1));

function DFS(s, e) {
  if (s == e) return 0;
  if (M[s][e] != undefined) return M[s][e];
  let r = Infinity, temp = A[s][0] * A[e][1];
  for (let i = s; i < e; ++i)
    r = Math.min(r, DFS(s,i) + DFS(i+1,e) + A[i][1]*temp);
  return M[s][e] = r; 
}