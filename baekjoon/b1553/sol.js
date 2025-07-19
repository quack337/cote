let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split('').map(e=>+e)),
DD=[[-1,0],[0,1],[1,0],[0,-1]],
RO=8, CO=7, X=0,
V=Array(RO).fill().map(_=>[]);
DFS(0,0)
console.log(X)

function DFS(r,c) {
  if (c==CO) {c=0; if (++r==RO) {++X; return}}
  let a=A[r][c]
  if (a==9) return DFS(r,c+1)
  for (let i=0; i<4; ++i) {
    let r1=r+DD[i][0], c1=c+DD[i][1]
    if (r1<0||c1<0||r1>=RO||c1>=CO) continue
    let b=A[r1][c1]
    if (b==9) continue
    if (!V[a][b]) {
      V[a][b]=V[b][a]=1; A[r][c]=A[r1][c1]=9
      DFS(r,c+1)
      V[a][b]=V[b][a]=0; A[r][c]=a; A[r1][c1]=b
    }
  }
}