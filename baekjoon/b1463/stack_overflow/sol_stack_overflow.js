X=+(require('fs').readFileSync(0)+'').trim()
M=[]
DP=x=>{
  if (x==1) return 0
  if (M[x]) return M[x]
  let r=DP(x-1)+1 // stack overflow error
  if (x%3==0) r=Math.min(r,DP(x/3)+1)
  if (x%2==0) r=Math.min(r,DP(x/2)+1)
  return M[x]=r
}
console.log(DP(X))