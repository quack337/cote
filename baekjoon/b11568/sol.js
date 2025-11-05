D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
A=D[1];
M=Array(N).fill().map(_=>[]);
BT=(n,p)=>{
  if(n==N)return 0;
  if(M[n][p]!=undefined)return M[n][p];
  return M[n][p]=Math.max(BT(n+1,p),A[n]>p?BT(n+1,A[n])+1:0);
}
console.log(BT(0,0));
