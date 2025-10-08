N=+(require('fs').readFileSync(0)+'');
T=Array(N+1).fill(0n);
T[0]=1n;
for(let n=1;n<=N;++n)
 for(let i=0;i<n;++i)
  T[n]+=T[i]*T[n-i-1];
console.log(T[N]+'');