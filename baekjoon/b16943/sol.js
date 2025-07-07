let D = require('fs').readFileSync(0).toString().trim().split(' '),
 A = D[0].split('').map(e=>+e), N=A.length, B=+D[1], V=[], 답=-1;
DFS(0, 0);
console.log(답);

function DFS(n, c) {
  if (n==N) {
    if (c>답) 답=c;
    return;
  }
  for (let i=0; i<N; ++i) {
    let c2 = c*10 + A[i];
    if (!V[i] && n+A[i] > 0 && c2 < B) {
      V[i] = true;
      DFS(n+1, c2)
      V[i] = false;
    }
  }
}