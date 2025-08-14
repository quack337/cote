N=+(require('fs').readFileSync(0)+'')
M=Array(N+1).fill(-1)
BT=n=>{
  if (M[n]>-1) return M[n]
  if (!n) return M[n]=0
  let to=Math.sqrt(n), r=Infinity
  for (let i=1; i<=to; ++i)
    r = Math.min(r, BT(n-i*i)+1)
  return M[n]=r
}
console.log(BT(N))