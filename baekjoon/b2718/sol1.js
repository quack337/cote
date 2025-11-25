BT=(r,c)=>{
  console.log(r,c);
  if(c>=N){
    if(r==3){ console.log(r,c,1); return 1; }
    return BT(r+1,0);
  }
  if(A[r][c])return BT(r,c+1);
  let a=0,b=0;
  if(c<N-1 && !A[r][c+1]) {A[r][c]=A[r][c+1]=1; BT(r,c+2); A[r][c]=A[r][c+1]=0;}
  if(r<4-1 && !A[r+1][c]) {A[r][c]=A[r+1][c]=1; BT(r,c+1); A[r][c]=A[r+1][c]=0;}
  return a+b;
}

for(N=2;N<=2;++N){
  A=Array(4).fill().map(_=>[]);
  console.log(N, BT(0,0));
}