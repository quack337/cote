let R = +require('fs').readFileSync(0).toString().trim()
let A=[1,5,10,50], N=4, set=new Set()
DFS(0,3,0,0)
console.log(set.size)

function DFS(from, to, sum, cnt) {
  if (cnt==R) set.add(sum)
  else
    for (let i=from; i<=to; ++i)
      DFS(i, to, sum+A[i], cnt+1)
}