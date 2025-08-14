// 버그 visited 처리를 안했음
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
let[N,W]=D.shift()
A=D.map(([w,v])=>({w,v}))
M=[]
console.log(BT(W))

function BT(w) {
  if(!w) return 0
  if(M[w]) return M[w]
  let mx = 0
  for (let i=0; i<N; ++i)
    if(A[i].w <= w)
      mx=Math.max(mx, BT(w-A[i].w) + A[i].v)
  return M[w]=mx
}
