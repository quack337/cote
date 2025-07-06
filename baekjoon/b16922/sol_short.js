let R=+require('fs').readFileSync(0).toString().trim(),
 A=[1,5,10,50], N=4, S=new Set()
DFS(0,3,0,0)
console.log(S.size)

function DFS(from, to, x, n) {
  if (n==R) S.add(x)
  else
    for (let i=from; i<=to; ++i)
      DFS(i, to, x+A[i], n+1)
}