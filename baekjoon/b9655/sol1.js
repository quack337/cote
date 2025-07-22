N=+require('fs').readFileSync(0)
memo=[0,1,2,1]
for (let i=4; i<=N; ++i)
  memo[i] = Math.min(memo[i-1], memo[i-3]) + 1
console.log(memo[N]%2 ? 'SK' : 'CY')
