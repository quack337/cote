let X = require('fs').readFileSync(0).toString().trim(),
 N = X.length, A = X.split('').map(e=>+e).sort((a,b)=>a-b), V = [];
console.log(DFS(0,0));

function DFS(n, x) {
  if (n==N) return x>X ? x : 0;
  for (let i=0; i < N; ++i)
    if (!V[i]) {
      V[i] = 1;
      let r = DFS(n+1, x*10+A[i]);
      if (r) return r;
      V[i] = 0;
    }
  return 0;
}
