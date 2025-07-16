let nums= s=>s.split(' ').map(e=>+e),
IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], A=IN.slice(1,1+N).map(s=>nums(s)),[RX,GX,BX]=nums(IN[N+1]), X=Infinity;
DFS(0,0,0,0,0)
console.log(X)

function DFS(n,cnt,r,g,b) {
  if (cnt>7) return
  if (N-n+cnt<2) return
  if (cnt==7 || n==N) {
    let f = (x,c)=>Math.abs(x-Math.floor(c/cnt))
    let x = f(RX,r)+f(GX,g)+f(BX,b)
    if (x<X) X=x
    return
  }
  DFS(n+1, cnt+1, r+A[n][0], g+A[n][1], b+A[n][2])
  DFS(n+1, cnt, r,g,b)
}
