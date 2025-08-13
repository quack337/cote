let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = [];
for (let i=0; i < N; ++i)
  A[i] = getInt();
let V = 1000; // 수열의 최대값
let M = Array(N+1).fill().map(e => Array(V+1).fill(-1));
console.log(DFS(0,0))

function DFS(n, prev) {
  if (n==N) return 0;
  if (M[n][prev] > -1) return M[n][prev];
  let a = A[n]>prev ? DFS(n+1, A[n]) + 1 : 0;
  let b = DFS(n+1, prev);
  return M[n][prev] = Math.max(a, b);
}