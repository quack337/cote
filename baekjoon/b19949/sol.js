let A = require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e);
let S = [], CNT = 0;
DFS(0,0);
console.log(CNT);

function DFS(n, pt) {
  if (n == 10) {
    if (pt >= 5) ++CNT;
    return;
  }
  for (let i=1; i<=5; ++i) {
    if (n >= 2 && S[n-1]==i && S[n-2]==i) continue;
    S.push(i);
    DFS(n+1, pt + (A[n]==i ? 1 : 0));
    S.pop(i);
  }
}
