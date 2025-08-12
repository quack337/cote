let N, 답, A
for (N=1; N<=20; ++N) {
  답 = 0
  A=[[],[]]
  BT(0,0)
  console.log("%d: %d", N, 답)
}

function BT(r,c) {
  if (c==N) {
    c=0;
    if (++r==2) { ++답; return}
  }
  if (A[r][c]) return BT(r,c+1)
  if (c<N-1) { A[r][c]=A[r][c+1]=1; BT(r,c+2); A[r][c]=A[r][c+1]=0 }
  if (r==0) { A[r][c]=A[r+1][c]=1; BT(r,c+1); A[r][c]=A[r+1][c]=0 }
  if (c<N-1 && r==0) { A[r][c]=A[r+1][c]=A[r][c+1]=A[r+1][c+1]=1; BT(r,c+2); A[r][c]=A[r+1][c]=A[r][c+1]=A[r+1][c+1]=0 }
}
