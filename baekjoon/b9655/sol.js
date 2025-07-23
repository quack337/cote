N=+require('fs').readFileSync(0)
memo=[]
console.log(DFS(N)%2 ? 'SK' : 'CY')

function DFS(n) {
  if (n<0) return Infinity
  if (n==0) return 0
  if (memo[n]) return memo[n]
  return memo[n] = Math.min(DFS(n-3), DFS(n-1)) + 1
}