let A = require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e);
let S = [], CNT = 0;
DFS(0,0,-1,-1);
console.log(CNT);

function DFS(n, pt, pre1, pre2) {
  if (10-n+pt < 5) return;
  if (n == 10) {
    if (pt >= 5) ++CNT;
  }
  else
    for (let i=1; i<=5; ++i)
      if (pre1 != i || pre2 != i)
        DFS(n+1, pt + (A[n]==i ? 1 : 0), i, pre1);
}
