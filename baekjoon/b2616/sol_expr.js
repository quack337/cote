D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0],A=D[1],K=D[2][0];
B=Array(N).fill(0);
for(let i=0;i<K;++i)B[0]+=A[i];
for(let i=1;i<=N-K;++i)B[i]=B[i-1]+A[i+K-1]-A[i-1];
P=Array(N+2).fill().map(_=>[0,0,0,0]);
for(let i=N-K;i>=0;--i)
 for(let j=1;j<4;++j)
  P[i][j]=Math.max(B[i]+P[i+K][j-1], P[i+1][j]);
console.log(P[0][3]);