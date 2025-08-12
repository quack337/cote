N=+require('fs').readFileSync(0)
M=Array(91).fill().map(_=>[])
console.log(BT(N-1, 1)+'')

function BT(n, prev) {
  if (n==0) return 1n
  if (M[n][prev]) return M[n][prev]
  let a=0n, b=BT(n-1, 0)
  if (prev==0) a=BT(n-1, 1)
  return M[n][prev] = a+b
}