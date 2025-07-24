let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN.shift(), A=IN.map(s=>s.split(' ').map(e=>+e)), M=Array(500).fill().map(_=>[])
console.log(BT(0,0))

function BT(r,c) {
  if (r==N-1) return A[r][c]
  if (M[r][c]) return M[r][c]
  return M[r][c] = Math.max(BT(r+1,c), BT(r+1,c+1)) + A[r][c]
}