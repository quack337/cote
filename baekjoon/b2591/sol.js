A=(require('fs').readFileSync(0)+'').trim().split('').map(e=>+e);
N=A.length;
M=Array(N);
BT=n=>{
  if(n==N)return 1;
  if(M[n]!=undefined)return M[n];
  if(A[n]==0)return M[n]=0;
  return M[n]=BT(n+1) + (n<N-1 && (A[n]<3 || (A[n]==3&&A[n+1]<5)) ? BT(n+2) : 0);
}
console.log(BT(0))