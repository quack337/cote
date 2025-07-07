let dd = require('fs').readFileSync(0).toString().split('\n'),
 [ROW,COL,R] = dd[0].split(' ').map(e=>+e), N=ROW*COL,
 A = dd.slice(1).map(e=>e.split(' ').map(e=>+e)), V = A.map(e=>[]), 답=-Infinity;
DFS(0,N-R,0,0);
console.log(답);

function DFS(from,to,cnt,sum) {
  if (cnt==R) 답 = Math.max(답,sum)
  else {
    for (let i=from; i<=to; ++i) {
      let c = i % COL, r = (i-c) / COL;
      if (V[r][c] || (r>0 && V[r-1][c]) || (c>0 && V[r][c-1]) || (r<ROW-1 && V[r+1][c]) || (c<COL-1 && V[r][c+1]))
        continue;
      V[r][c] = true;
      DFS(from+1, to+1, cnt+1, sum+A[r][c]);
      V[r][c] = false;
    }
  }
}
