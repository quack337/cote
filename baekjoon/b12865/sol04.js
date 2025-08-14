let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e)),
[N,K]=A.shift(),
W=A.map(a=>a[0]), V=A.map(a=>a[1])
M=Array(N).fill().map(_=>[])
console.log(BT(0,K))

function BT(i,w) {
  if(i>=N || w<=0) return 0
  if(M[i][w]) return M[i][w]
  let v=BT(i+1, w)
  return M[i][w] = w<W[i] ? v : Math.max(v, BT(i+1, w-W[i]) + V[i])
}