let A=require('fs').readFileSync(0).toString().split(/[\n ]/).map(e=>+e);
let N=A.shift();
let M=Array(N).fill().map(_=>[]);
console.log(DFS(1,A[0]) + '');

function DFS(n, s) {
  if (n==N-1) return s == A[n] ? 1n : 0n;
  if (s < 0n || s > 20n) return 0n;
  if (M[n][s] != undefined) return M[n][s];
  return M[n][s] = DFS(n+1, s+A[n]) + DFS(n+1, s-A[n]);
}