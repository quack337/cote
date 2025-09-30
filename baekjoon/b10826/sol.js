let N=+require('fs').readFileSync(0).toString().trim();
let M=Array(N+1);
M[0]=0n; M[1]=1n;
for (let i=2; i<=N; ++i)
  M[i]=M[i-1]+M[i-2];
console.log(M[N]+'');