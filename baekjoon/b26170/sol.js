let DD=[[-1,0],[0,1],[1,0],[0,-1]], nums=s=>s.split(' ').map(e=>+e),
IN=require('fs').readFileSync(0).toString().split('\n'),
A=IN.map(s=>nums(s)),[r,c]=A[5], X=Infinity
DFS(r,c,0,0)
console.log(X==Infinity ? -1 : X)

function DFS(r,c,eat,dist) {
  if (dist>=X) return
  let old=A[r][c]
  A[r][c]=-1
  for (let [dr,dc] of DD) {
    let r1=r+dr, c1=c+dc
    if (r1<0||c1<0||r1>4||c1>4) continue
    if (A[r1][c1]==0)
      DFS(r1,c1,eat,dist+1)
    else if (A[r1][c1]==1) {
      if (eat+1==3 && dist+1<X) X=dist+1
      DFS(r1,c1,eat+1,dist+1)
    }
  }
  A[r][c]=old
}
