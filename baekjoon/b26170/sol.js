let DD=[[-1,0],[0,1],[1,0],[0,-1]], nums=s=>s.split(' ').map(e=>+e),
IN=require('fs').readFileSync(0).toString().split('\n'),
A=IN.slice(0,5).map(s=>nums(s)), [r0,c0]=nums(IN[5]), X=Infinity
DFS(r0,c0,0,0)
console.log(X==Infinity ? -1 : X)

function DFS(r,c,eat,dist) {
  if (dist>25 || dist>=X) return
  A[r][c]=-1
  for (let [dr,dc] of DD) {
    let r1=r+dr, c1=c+dc
    if (r1<0||c1<0||r1>3||c1>3) continue
    if (A[r1][c1]==-1) continue
    if (A[r1][c1]==1) {
      if (eat+1==3 && dist+1<X) X=dist+1
      A[r1][c1]=0; DFS(r1,c1,eat+1,dist+1); A[r1][c1]=1
    } else
      DFS(r1,c1,eat,dist+1)
  }
  A[r][c]=0
}
