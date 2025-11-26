D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
C=Array(N+1).fill(1);
for(let i=0;i<N;++i)C[A[i]]++;
X=1;
for(let i=0;i<=N;++i)X=X*C[i]%(1e9+7);
console.log(X-1)