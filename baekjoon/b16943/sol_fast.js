let D = require('fs').readFileSync(0).toString().trim().split(' '),
 A = D[0].split('').map(e=>+e).sort((a,b)=>b-a), N=A.length, B=+D[1], V=[];
console.log(DFS(0, 0));

function DFS(n, c) {
  if (n==N) return c<B ? c : -1;
  for (let i=0; i<N; ++i) {
    if (!V[i] && n+A[i] > 0) {
      V[i] = true;
      let r = DFS(n+1, c*10 + A[i]);
      if (r > -1) return r;
      V[i] = false;
    }
  }
  return -1;
}