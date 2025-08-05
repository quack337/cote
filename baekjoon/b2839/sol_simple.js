let N = parseInt(require('fs').readFileSync(0).toString().trim());
let memo=[];
let x = DFS(N)
console.log(x==Infinity ? -1 : x)

function DFS(n) {
  if (n<0) return Infinity;
  if (n==0) return 0;
  if (memo[n] > 0) return memo[n];
  return memo[n] = Math.min(DFS(n-5), DFS(n-3)) + 1;
}
