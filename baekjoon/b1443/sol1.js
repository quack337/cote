// 중복순열 - 시간초과
let [D,N]=require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
pow=Math.pow, MAX=pow(10,D), X=-1, S=[]
DFS(1,0)
console.log(X)

function DFS(x,n) {
  if (n>N || x>=MAX || x*pow(9,N-n)<X) return
  if (x>X) { X=x; console.log(x, S.join(' ')) }
  for (let i=9; i>1; --i) {
    S.push(i)
    if (x*i<MAX) DFS(x*i,n+1)
    S.pop()
  }
}
