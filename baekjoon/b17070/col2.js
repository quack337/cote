let IN = require('fs').readFileSync(0).toString().split('\n');
let N = +IN[0];
let A = IN.slice(1).map(s=>s.split(' ').map(e=>+e));
console.log(DFS(0,0,0));

function DFS(r, c, d) {
  if (d==0 && r==N-1 && c==N-2) return 1;
  if (d==1 && r==N-2 && c==N-1) return 1;
  if (d==2 && r==N-2 && c==N-2) return 1;
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
  return sum;
}