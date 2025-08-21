let N = +require('fs').readFileSync(0).toString();
let M = Array(N+1).fill().map(_=>[]);
console.log(DFS(N, 0));

function DFS(n, prev) {
  if (n == 0) return 1;
  if (M[n][prev]>0) return M[n][prev];
  let r = 0;
  for (let i=prev; i <= 9; ++i)
    r = (r + DFS(n-1, i)) % 10007;
  return M[n][prev] = r;
}