N=+require('fs').readFileSync(0)
P=1
S=-1
for(i=2;i<=N;++i)P=(P*2+(S*=-1))%10007
console.log(P)