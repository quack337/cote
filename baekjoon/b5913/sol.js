let IN=require('fs').readFileSync(0).toString().split('\n'),
K=+IN[0], N=5, A=[[],[],[],[],[]], X=0, S=[]
for (let i=1; i<=K; ++i) {
  let [r,c] = IN[i].split(' ').map(e=>+e)
  A[r-1][c-1]=1;
}
DFS(0,0,1)
console.log(X)

function DFS(r,c,v) {
  if (A[r][c]) return
  if (r==N-1 && c==N-1) {
    if (v==N*N-K) ++X;
    return
  }
  A[r][c]=1; S.push([r,c])
  if (r>0) DFS(r-1,c,v+1)
  if (c>0) DFS(r,c-1,v+1)
  if (r<N-1) DFS(r+1,c,v+1)
  if (c<N-1) DFS(r,c+1,v+1)
  A[r][c]=0; S.pop()
}

