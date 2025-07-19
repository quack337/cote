X=+(require('fs').readFileSync(0)+'').trim()
M=[0]
M[1]=0
for (let x=2; x<=X; ++x) {
  let a=X, b=X, c=X
  if (x%3==0) a=M[x/3]+1
  if (x%2==0) b=M[x/2]+1
  c=M[x-1]+1
  M[x]=Math.min(a,b,c)
}
console.log(M[X])
