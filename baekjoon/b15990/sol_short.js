A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e)
T=A[0], N=Math.max(...A), X=[], M=Array(4).fill().map(_=>Array(N+1).fill(0))
M[1][1]=1;M[2][2]=1;M[1][3]=M[2][3]=M[3][3]=1
MOD=1000000009
for(n=4;n<=N;++n)
 for(i=1;i<4;++i)
  M[i][n]=((i!=1?M[1][n-i]:0)+(i!=2?M[2][n-i]:0)+(i!=3?M[3][n-i]:0))%MOD
for(t=1;t<=T;++t)X.push((M[1][A[t]]+M[2][A[t]]+M[3][A[t]])%MOD)
console.log(X.join('\n'))