// 답.. 그렇지만 느림 1초 이상
let IN=require('fs').readFileSync(0).toString().split('\n'),
[RN,CN,T]=IN[0].split(' ').map(e=>+e),
A=IN.slice(1).map(s=>s.split('')), V=A.map(_=>[]), G, X=0, PATH=[]
findG()
DFS(G[0],G[1],T,[])
console.log(X)

function DFS(r,c,t,eat) {
  if (V[r][c] || A[r][c]=='#') return
  if (A[r][c]=='S') {
    let rc = r*100+c
    if (!eat.includes(rc)) {
      eat = [...eat, rc]
      V=A.map(_=>[])
    }
  }
  if (eat.length > X) X = eat.length
  if (t==0) return
  V[r][c]=1
  if (r>0) DFS(r-1,c,t-1,eat)
  if (c>0) DFS(r,c-1,t-1,eat)
  if (r<RN-1) DFS(r+1,c,t-1,eat)
  if (c<CN-1) DFS(r,c+1,t-1,eat)
  V[r][c]=0
}

function findG() {
  for (let r=0; r<RN; ++r)
    for (let c=0; c<CN; ++c)
      if (A[r][c]=='G') {
        G=[r,c];
        return;
      }
}
