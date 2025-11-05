N=+(require('fs').readFileSync(0)+'');
M=Array(N+1);
M[0]=M[1]=1;
for(let i=2;i<=N;++i)M[i]=(M[i-1]+M[i-2]+1)%(1e9+7);
console.log(M[N]);