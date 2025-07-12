let N=+require('fs').readFileSync(0).toString().trim(),
V=Array(2*N+2).fill().map(_=>[]),
DD=[[-1,0],[1,0],[-1,1],[1,-1],[-1,-1],[1,1]],
MV=[[2,4],[3,5],[0,5],[4,1],[0,3],[1,2]],X=0;
let r=N+2, c=N+2;
V[r][c]=V[--r][c]=1
DFS(0,r,c,0)
console.log(X)

function DFS(n,r,c,mv) {
  for (let mv1 of MV[mv]) {
    let [dr,dc]=DD[mv1], r1=r+dr, c1=c+dc
    if (n<N-1 && !V[r1][c1]) {
      V[r1][c1]=1
      DFS(n+1,r1,c1,mv1)
      V[r1][c1]=0
    } else if (n==N-1 && V[r1][c1]) ++X;
  }
}