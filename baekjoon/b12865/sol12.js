let IN=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
let [N, K] = IN;
let W = IN.filter((e,i) => i%2==0 && i>1);
let V = IN.filter((e,i) => i%2==1 && i>1);
console.log(DFS(0,K));

function DFS(n,k) {
  if (n==N) return 0;
  let a = k>=W[n] ? DFS(n+1, k-W[n]) + V[n] : 0;
  let b = DFS(n+1, k);
  return Math.max(a, b);
}