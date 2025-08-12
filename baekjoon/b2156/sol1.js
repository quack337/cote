// 시간초과
A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e)
N=A.shift()
M=Array(N).fill().map(_=>[])
console.log(BT(0,0))

function BT(i,prev) {
  if (i==N) return 0
  if (M[i][prev]) return M[i][prev]
  let a=BT(i+1,0), b=0
  if (prev<2) b=BT(i+1,prev+1) + A[i]
  return M[i][prev]=Math.max(a,b)
}