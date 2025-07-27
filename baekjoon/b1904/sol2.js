//메모리 초과
N=+require('fs').readFileSync(0)
M=[1n,1n]
for(i=2;i<=N;++i)M[i]=M[i-1]+M[i-2]
console.log(M[N]+'')