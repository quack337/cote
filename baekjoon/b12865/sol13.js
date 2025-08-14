let IN=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
let [N, K] = IN;
let W = IN.filter((e,i) => i%2==0 && i>1);
let V = IN.filter((e,i) => i%2==1 && i>1);
let M = Array(N+1).fill().map(_=>Array(K+1).fill(-1));
console.log(DFS(0,K));

function DFS(n,k) {
  if (M[n][k]>-1) return M[n][k];
  if (n==N) return M[n][k] = 0;
  let a = k>=W[n] ? DFS(n+1, k-W[n]) + V[n] : 0;
  let b = DFS(n+1, k);
  return M[n][k] = Math.max(a, b);
}