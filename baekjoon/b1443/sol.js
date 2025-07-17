// 중복조합
let [D,N]=require('fs').readFileSync(0).toString().split(' ').map(e=>+e),
pow=Math.pow, MAX=pow(10,D), X=-1
DFS(2,1,0)
console.log(X)

function DFS(from,x,n) {
  if (n==N) { if (x>X) X=x; return }
  //if (x*pow(9,N-n)<X) return
  for (let i=from; i<=9; ++i)
    if (x*i<MAX) DFS(i,x*i,n+1)
}
