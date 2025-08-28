// 메모리 초과
let IN = require('fs').readFileSync(0).toString().split('\n');
let N = +IN[0];
let A = IN.slice(1).map(s=>s.split(' ').map(e=>+e));
let M = Array(N).fill().map(_=>[-1,-1,-1]);
let MNX = Math.max; mx = DFS(0,1);
M = Array(N).fill().map(_=>[-1,-1,-1])
MNX = Math.min; mn = DFS(0,1);
console.log(mx, mn);

function DFS(n,prev) {
  if (n==N) return 0;
  if (M[n][prev]>-1) return M[n][prev];
  let r = DFS(n+1, 1) + A[n][1];
  if (prev != 2) r = MNX(r, DFS(n+1,0) + A[n][0]);
  if (prev != 0) r = MNX(r, DFS(n+1,2) + A[n][2]);
  return M[n][prev] = r; 
}

