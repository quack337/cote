// 답
N=+require('fs').readFileSync(0)
M=Array(N+1).fill().map(_=>[])
let sum=0
for (let p=1; p<=9; ++p)
  sum += BT(N-1, p)
console.log(sum%1_000_000_000)

function BT(n,p) {
  if (n==0) return 1
  if (M[n][p]) return M[n][p]
  let a=0, b=0
  if (p<9) a=BT(n-1, p+1)
  if (p>0) b=BT(n-1, p-1)
  return M[n][p]=(a+b)%1_000_000_000
}