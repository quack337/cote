let [N,X]=require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
V=[], A=[], M=[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1],
[1,7,21,35,35,21,7,1],[1,8,28,56,70,56,28,8,1],[1,9,36,84,126,126,84,36,9,1]]
DFS(0)

function DFS(n) {
  if (n==N) {
    let x = A.reduce((r,e,i)=>r+e*M[N-1][i],0)
    if (x==X) { console.log(A.join(' ')); process.exit(0) }
  } else
    for (let i=1; i<=N; ++i)
      if (!V[i]) { V[i]=1; A[n]=i; DFS(n+1); V[i]=0 }
}
