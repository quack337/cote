N=+(require('fs').readFileSync(0)+'')
M=Array(N).fill().map(_=>[])
console.log(DFS(0,0));

function DFS(n, prev) {
  if (n==N) return 1;
  if (M[n][prev]) return M[n][prev];
  let r = DFS(n+1, 0) % 9901;
  if (prev != 1) r = (r + DFS(n+1, 1)) % 9901;
  if (prev != 2) r = (r + DFS(n+1, 2)) % 9901;
  return M[n][prev] = r; 
}