[A,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
M=Array(K+1);
BT=n=>{
  if(n>K)return Infinity;
  if(n==K)return 0;
  if(M[n])return M[n]; 
  return M[n]=Math.min(BT(n+1),BT(n*2))+1;
}
console.log(BT(A));