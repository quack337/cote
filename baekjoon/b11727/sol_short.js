N=+require('fs').readFileSync(0)
P=1
for(i=2;i<=N;++i)P=(P*2+[1,-1][i%2])%10007
console.log(P)