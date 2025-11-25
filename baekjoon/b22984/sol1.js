A=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=A.shift();
M=Array(N).fill().map(_=>[,,]);
BT=(n,p)=>{
  if(n==N)return 0;
  if(M[n][p]!=undefined)return M[n][p];
  return M[n][p] =
    (BT(n+1,1) + 1 + (p?0:1)) * A[n] +
    (BT(n+1,0) + 0 + (p?1:0)) * (1-A[n]);
}
console.log(BT(1,0)*(1-A[0]) + (BT(1,1)+1)*A[0])
