// 백트레킹으로 구현. 당연히 매우 느림.
for(N=2;N<=20;N+=2){
  M=Array(N).fill().map(e=>[]);
  console.log(N, BT(0,0));
}

function BT(n,x){
  if(n==N) return x?0:1;
  if(M[n][x]!=undefined)return M[n][x];
  return M[n][x]=(BT(n+1,x+1)+(x?BT(n+1,x-1):0))%1000000007;
}