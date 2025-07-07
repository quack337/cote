let [N,K] = require('fs').readFileSync(0).toString().split(' ').map(e=>+e),
 k=0, S=[];
console.log(DFS(0) ? S.join('+') : -1);

function DFS(n) {
  if (n==N && ++k==K) return true;
  for (let i=1; i<=3 && n+i<=N; ++i) {
    S.push(i);
    if (DFS(n+i)) return true;
    S.pop();
  }
  return false;
}