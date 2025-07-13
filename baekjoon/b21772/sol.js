let IN=require('fs').readFileSync(0).toString().split('\n'),
DD=[[-1,0],[0,1],[1,0],[0,-1]],
[RN,CN,T]=IN[0].split(' ').map(e=>+e),
A=IN.slice(1).map(s=>s.split('')), G, X=0, PATH=[]
for (let r=0; r<RN && !G; ++r)
  for (let c=0; c<CN; ++c)
    if (A[r][c]=='G') G=[r,c]
DFS(G[0],G[1],T,0)
console.log(X)

function DFS(r,c,t,x) {
  if (x+t <= X) return
  if (A[r][c]=='#') return
  if (x > X) X = x;
  if (t == 0) return
  for (let [dr, dc] of DD) {
    let r1=r+dr, c1=c+dc
    if (r1<0||c1<0||r1>=RN||c1>=CN) continue
    if (A[r1][c1]=='#') continue
    if (A[r1][c1]=='S') {
      A[r1][c1]='_'
      DFS(r1,c1,t-1,x+1)
      A[r1][c1]='S'
    } else DFS(r1,c1,t-1,x)
  }
}
