let IN = require('fs').readFileSync(0).toString().split('\n');
let N = +IN.shift();
let A = IN.map(s => s.split(' ').map(e=>+e));
A.unshift([0, 0]);
let M = Array(N+1).fill(-1);
console.log(N - DFS(0));

function DFS(prev) {
  if (M[prev]>-1) return M[prev];
  let r = 0, [s, e] = A[prev];
  for (let i = 1; i <= N; ++i)
    if (A[i][0] > s && A[i][1] > e)
      r = Math.max(r, DFS(i) + 1);
  return M[prev] = r;
}