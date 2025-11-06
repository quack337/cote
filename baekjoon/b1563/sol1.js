for(N=1;N<=1000;++N){
  M=Array(N).fill().map(_=>Array(3).fill().map(_=>[]));
  console.log(N,BT(0,0,0));
}

function BT(n,a,l){
  if(n==N) return 1;
  if(M[n][a][l]!=undefined)return M[n][a][l];
  return M[n][a][l]=(BT(n+1,0,l) +
    (a>=2 ? 0 : BT(n+1,a+1,l)) +
    (l ? 0 : BT(n+1,0,1)))%1e6;
}