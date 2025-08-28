// 점화식으로 풀었음. 제춣진 않았지만, 메모리초과겠지.
let IN = require('fs').readFileSync(0).toString().split('\n');
let N = +IN[0];
let A = IN.slice(1).map(s=>s.split(' ').map(e=>+e));
let M = Array(N).fill().map(_=>[-1,-1,-1]);
let MNX = Math.max; mx = DFS(0,1);
M = Array(N).fill().map(_=>[-1,-1,-1])
MNX = Math.min; mn = DFS();
console.log(mx, mn);

function DFS() {
  M[N-1] = [...A[N-1]];
  for (let i=N-2; i>=0; --i) {
    M[i][0] = MNX(M[i+1][0], M[i+1][1]) + A[i][0];
    M[i][1] = MNX(M[i+1][0], M[i+1][1], M[i+1][2]) + A[i][1];
    M[i][2] = MNX(M[i+1][1], M[i+1][2]) + A[i][2];
  }
  return MNX(M[0][0], M[0][1], M[0][2])
}
