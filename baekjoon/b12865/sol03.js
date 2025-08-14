// 답.. 그러나 느리다.. 흠..
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
let[N,W]=D.shift()
A=D.map(([w,v])=>({w,v}))
M=Array(N).fill().map(_=>[])
console.log(BT(0,W))

function BT(i,w) {
  if(!w || i==N) return 0
  if(M[i][w]) return M[i][w]
  let v1=0, v2=0
  if (A[i].w<=w) v1=BT(i+1,w-A[i].w)+A[i].v
  v2=BT(i+1,w)
  return M[i][w] = Math.max(v1, v2)
}