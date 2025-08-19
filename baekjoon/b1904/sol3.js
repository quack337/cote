N=+require('fs').readFileSync(0)
M=[0, 1, 2]
for(i=3; i<=N; ++i)
  M[i%3] = (M[(i-1)%3] + M[(i-2)%3]) % 15746
console.log(M[N%3])