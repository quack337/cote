//메모리 초과
N=+require('fs').readFileSync(0)
M=[0, 1, 2]
for(i=3; i<=N; ++i)
  M[i] = (M[i-1] + M[i-2]) % 15746
console.log(M[N])