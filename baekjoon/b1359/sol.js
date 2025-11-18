[N,M,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
C=Array(N+1).fill().map((_,i)=>Array(i+1).fill(1));
for(let n=2;n<=N;++n)
for(let r=1;r<n;++r)C[n][r]=C[n-1][r-1]+C[n-1][r];
X=0;
for(let k=K;k<=M;++k)
  X+=C[M][k]*((N-M<M-k)?0:C[N-M][M-k]);
console.log(X/C[N][M])