let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN.shift(), A=IN.map(s=>s.split(' ').map(e=>+e)), M=[[],[],[]]
console.log(BT(0,-1))

function BT(n, prev) {
  if (n==N) return 0
  if (prev!=-1 && M[prev][n]) return M[prev][n]
  let min = Infinity
  for (let i=0; i<3; ++i)
    if (i != prev)
      min = Math.min(min, BT(n+1, i) + A[n][i])
  if (prev != -1) return M[prev][n] = min
  return min
}