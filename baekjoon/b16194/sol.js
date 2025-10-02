let A=require('fs').readFileSync(0).toString().split(/[\n ]/).map(e=>+e);
let N=A.shift();
let M=[];
console.log(DFS(N));

function DFS(n) {
  if (n==0) return 0;
  if (M[n]) return M[n];
  let pmin = Infinity;
  for (let i=1; i<=n; ++i) {
    let p = DFS(n-i) + A[i-1];
    if (p < pmin) pmin = p;
  }
  return M[n] = pmin;
}