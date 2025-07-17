// 중복조합
let [D,N]=require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
pow=Math.pow, MAX=pow(10,D), X=-1
DFS(2,1,0)
console.log(X)

function DFS(from,x,n) {
  if (x>=MAX) return
  if (n==N) {
    if (x>X) X=x
    return
  }
  if (x*pow(9,N-n)<X) return
  for (let i=9; i>=from; --i)
    DFS(i,x*i,n+1)
}
