let N=+require('fs').readFileSync(0)
M=[0,1,2]
for (let i=3; i<=N; ++i)
  M[i]=(M[i-1]+M[i-2])%10007
console.log(M[N])