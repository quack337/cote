let IN=require('fs').readFileSync(0).toString().split('\n');
let N=IN[0];
let A=IN[1].split(' ').map(e=>+e);
let M=Array(N).fill().map(_=>[]);
console.log(M)
console.log(DFS(0, 0));

function DFS(n, prev) {
  if (n==N) return 0;
  if (M[n][prev]) return M[n][prev];
  return  M[n][prev] = Math.max(DFS(n+1, prev), A[n]>prev ? DFS(n+1, A[n])+1 : 0); 
}