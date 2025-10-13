for (N=0; N<=8; ++N) {
  A=Array(2).fill().map(_=>Array(N).fill(0));
  console.log(BT(0,0));
}

function BT(r,c){
  if (r==2) return 1;
  if (c==N) return BT(r+1,0);
  if (A[r][c]==1) return BT(r,c+1);
  let x=0;
  if (r==0 && A[r+1][c]==0) { A[r][c]=A[r+1][c]=1; x+=BT(r,c+1); A[r][c]=A[r+1][c]=0; }
  if (c<N-1 && A[r][c+1]==0) { A[r][c]=A[r][c+1]=1; x+=BT(r,c+1); A[r][c]=A[r][c+1]=0; }
  if (r==0 && c<N-1 && A[r+1][c]+A[r][c+1]+A[r+1][c+1]==0) { A[r][c]=A[r+1][c]=A[r][c+1]=A[r+1][c+1]=1; x+=BT(r,c+1); A[r][c]=A[r+1][c]=A[r][c+1]=A[r+1][c+1]=0; }
  return x;
}