X=+(require('fs').readFileSync(0)+'').trim()
M=[]
DP=(x)=>{
  if (x==1) return 0
  if (M[x]) return M[x]
  let a=X, b=X, c=X
  if (x%3==0) a=DP(x/3)+1
  if (x%2==0) b=DP(x/2)+1
  c=DP(x-1)+1
  return M[x]=Math.min(a,b,c)
}
console.log(DP(X))