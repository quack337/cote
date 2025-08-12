D=(require('fs').readFileSync(0)+'').split('\n')
N=+D.shift()
A=D.map(s=>s.split(' ').map(e=>+e))
M=Array(N).fill().map(_=>new Map())
console.log(BT(0,0))

function BT(index, flag) {
  if (index==N) return 0
  let memo = M[index]
  if (memo.has(flag)) return memo.get(flag)
  let a=0, b=0, [t, p]=A[index], f=(((1<<t)-1)<<index)
  if (f<(1<<N) && (flag & f) == 0)
    a = BT(index+1, flag|f) + p
  b = BT(index+1, flag)
  let val = Math.max(a, b)
  memo.set(flag, val)
  return val
}