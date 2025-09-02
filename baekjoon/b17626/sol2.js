let N = +require('fs').readFileSync(0).toString();
let M = [];
//console.log(DFS(N,0));

for (let i=1; i<=N; ++i)
  console.log(i, DFS(i,0));

function DFS(n,cnt) {
  if (n==0) return 0;
  if (cnt > 4) return Infinity;
  if (M[n] != undefined) return M[n];
  let e = Math.floor(Math.sqrt(n));
  let r = Infinity;
  for (let i=1; i<=e; ++i)
    r = Math.min(r, DFS(n - i*i, cnt+1) + 1);
  return M[n] = r;
}