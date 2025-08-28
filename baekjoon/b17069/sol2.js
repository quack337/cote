let IN = require('fs').readFileSync(0).toString().split('\n');
let N = +IN[0];
let A = IN.slice(1).map(s=>s.split(' ').map(e=>+e));
let M = Array(N).fill().map(_=>Array(N).fill().map(_=>[-1,-1,-1]));
M[N-1][N-2][0] = M[N-2][N-1][1] = M[N-2][N-2][2] = 1;
console.log(DFS(0,0,0));

function DFS(r, c, d) {
  if (M[r][c][d]>-1) return M[r][c][d];
  let sum = 0;
  if (d==0) {
    if (c<N-2 && !A[r][c+2]) sum += DFS(r, c+1, 0);
    if (c<N-2 && r<N-1 && !A[r][c+2] && !A[r+1][c+1] && !A[r+1][c+2]) 
      sum += DFS(r, c+1, 2);
  }
  else if (d==1) {
    if (r<N-2 && !A[r+2][c]) sum += DFS(r+1, c, 1);
    if (c<N-1 && r<N-2 && !A[r+2][c] && !A[r+1][c+1] && !A[r+2][c+1]) 
      sum += DFS(r+1, c, 2);
  }
  else if (d==2) {
    if (c<N-2 && !A[r+1][c+2]) sum += DFS(r+1, c+1, 0);
    if (r<N-2 && !A[r+2][c+1]) sum += DFS(r+1, c+1, 1);
    if (c<N-2 && r<N-2 && !A[r+1][c+2] && !A[r+2][c+1] && !A[r+2][c+2])
      sum += DFS(r+1, c+1, 2);
  }
  return M[r][c][d] = sum;
}