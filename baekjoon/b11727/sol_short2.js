N=+require('fs').readFileSync(0)
for(S=P=1;--N;S*=-1)P=P*2%10007+S
console.log(P)