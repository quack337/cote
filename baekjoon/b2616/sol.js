let D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let N=D[0][0], A=D[1], K=D[2][0];
let B=Array(N-K+1);
N=B.length;
B[0]=0;
for (let i=0; i<K; ++i) B[0]+=A[i];
for (let i=1; i<N; ++i)
  B[i]=B[i-1]+A[i+K-1]-A[i-1];
P=Array(N).fill().map(_=>[0]);
BT=(n,m)=>{
  if(n>=N) return 0;
  if(P[n][m]!=undefined) return P[n][m];
  return P[n][m]=Math.max(BT(n+1,m), BT(n+K,m-1)+B[n]);
}
console.log(BT(0,3));