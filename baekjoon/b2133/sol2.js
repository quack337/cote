N=+(require('fs').readFileSync(0))
M=[1,0,3,0]
for(i=4;i<=N;++i)M[i]=M[i-2]*4-M[i-4]
console.log(M[N])