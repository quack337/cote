let D = require('fs').readFileSync(0).toString().split('\n'),
 [N,K]=D[0].split(' ').map(e=>+e),
 A=D.slice(1).map(e=>e.split(' ').map(e=>+e));
for (let a=0; a<N; ++a)
  for (let b=0; b<N; ++b)
    for (let c=0; c<N; ++c)
      if (A[a][b] > A[a][c]+A[c][b])
        A[a][b] = A[a][c]+A[c][b];
let S=[K], V=[], 답=Infinity;
V[K] = true;
DFS(1, 0);
console.log(답);

function DFS(n, d) {
  if (n==N) 답 = d;
  else
  for (let i=0; i<N; ++i) {
    let d2 = d + A[S[n-1]][i];
    if (!V[i] && d2 < 답) {
      S.push(i); V[i] = true;
      DFS(n+1, d2);
      S.pop(); V[i] = false;
    }
  }
}
