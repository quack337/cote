let A=require('fs').readFileSync(0).toString().split(/[ \n]+/).map(e=>+e),
N=A.shift(), M=Array(1001).fill().map(_=>[])
console.log(BT(0,0))

function BT(n, prev) {
  if (n==N) return 0
  if (M[n][prev]) return M[n][prev]
  let max = A[n]>prev ? BT(n+1, A[n]) + 1 : 0
  max = Math.max(max, BT(n+1, prev))
  return M[n][prev] = max
}