let [N,K] = (require('fs').readFileSync(0)+'').split(' ').map(e=>+e)
M = Array(N+1).fill().map(_=>Array(K+1).fill(-1))
BT = (n,k)=>{
  if (M[n][k]>-1) return M[n][k]
  if (!k) return M[n][k] = n?0:1
  let r=0
  for(let i=0; i<=n; ++i)
    r = (r + BT(n-i,k-1)) % 1_000_000_000
 return M[n][k] = r
}
console.log(BT(N,K))
