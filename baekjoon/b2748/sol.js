N=+require('fs').readFileSync(0)
P=[0n,1n]
for(i=2;i<=N;++i)P[i]=P[i-1]+P[i-2]
console.log(P[N]+'')