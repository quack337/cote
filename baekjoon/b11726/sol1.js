// 백트레킹만 구현
let N, A,X
for (N=1; N<=9; ++N) {
  A=Array(2).fill().map(_=>Array(N).fill(0))
  X=0
  DFS(0,0)
  console.log("%d: %d", N, X)
}

function DFS(r,c) {
  if (c==N) {c=0; if (++r>1) return ++X}
  if (A[r][c]) return DFS(r,c+1)
  if (c<N-1) { A[r][c]=A[r][c+1]=1; DFS(r,c+1); A[r][c]=A[r][c+1]=0}
  if (r==0) { A[r][c]=A[r+1][c]=1; DFS(r, c+1); A[r][c]=A[r+1][c]=0}
}