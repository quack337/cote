let [N,X]=require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
V=[], A=Array(N).fill().map(_=>[])
DFS(0)

function DFS(n) {
  if (n==N) {
    for (let r=1; r<N; ++r)
      for (let c=0; c<N-r; ++c)
        A[r][c] = A[r-1][c] + A[r-1][c+1]
    if (A[N-1][0]==X) { console.log(A[0].join(' ')); process.exit(0) }
  } else
    for (let i=1; i<=N; ++i)
      if (!V[i]) { V[i]=1; A[0][n]=i; DFS(n+1); V[i]=0 }
}
