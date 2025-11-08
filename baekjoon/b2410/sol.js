N=+(require('fs').readFileSync(0)+'');
M=Array(N+1).fill(1);
for(let a=2;a<=N;a*=2)
for(let i=a;i<=N;++i)M[i]=(M[i]+M[i-a])%1e9;
console.log(M[N])