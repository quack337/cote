let IN=require('fs').readFileSync(0).toString().split('\n'),
nums= s => s.split(' ').map(e=>+e),
[N, M, K] = nums(IN[0]), 
Q = IN.slice(1).map(s=>nums(s).reduce((r,e)=> r | (1<<(e-1)), 0))
S=[], V=[], X=0
DFS(0,N,0,0)
console.log(X)

function DFS(from, to, set, size) {
  if (size==N) {
    let cnt = Q.reduce((r,q)=> (set&q)==q ? r+1 : r, 0)
    if (cnt > X) X = cnt
    return
  }
  for (let i=from; i<=to; ++i) 
    DFS(i+1, to+1, set | (1<<i), size+1)
}
