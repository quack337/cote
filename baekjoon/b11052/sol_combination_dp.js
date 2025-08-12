A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift()
M=Array(N).fill().map(_=>Array(N+1).fill(-1))
BT=(f,n)=>{
  if(!n) return 0
  if(M[f][n]>-1) return M[f][n]
  let r=0
  for(let i=f;i<N;++i)
    if(n>i) r=Math.max(r,BT(i,n-i-1)+A[i])
  return M[f][n]=r;
}
console.log(BT(0,N))