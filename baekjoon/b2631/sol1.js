let A=require('fs').readFileSync(0).toString().split('\n').map(e=>+e);
let N=A.shift();
let M = Array(N).fill().map(_=>[]);
console.log(N - DFS(0,0));

function DFS(n, prev) {
  if (n==N) return 0;
  if (M[n][prev] != undefined) return M[n][prev];
  let a = 0, b = 0;
  if (A[n] > prev) a = DFS(n+1, A[n]) + 1;
  b = DFS(n+1, prev);
  return M[n][prev] = Math.max(a, b);
}