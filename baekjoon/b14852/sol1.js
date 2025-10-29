// 수열의 계산식을 찾을 수 없다.
for(N=1; N<=15; ++N){
  A=Array(2).fill().map(_=>[]);
  X=0;
  BT(0,0)
  console.log(N, X);
}

function BT(r,c){
  if(c==N) { ++r; c=0; }
  if(r==2) {
    ++X;
    //console.log(A.map(a=>a.join('')).join('\n')+'\n');
    return;
  }
  if (A[r][c]) { BT(r,c+1); return; }
  A[r][c]=1; BT(r,c+1);
  if (c<N-1 && !A[r][c+1]) { A[r][c]=A[r][c+1]=2; BT(r,c+1); A[r][c+1]=0; }
  if (r<1 && !A[r+1][c]) { A[r][c]=A[r+1][c]=3; BT(r,c+1); A[r+1][c]=0; }
  A[r][c]=0;
}

