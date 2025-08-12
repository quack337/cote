A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift()
M=Array(N).fill().map(_=>Array(N+1).fill(-1))
BT=(n)=>{
 if(!n) return 0
 if(M[n]>-1) return M[n]
 let r=0
 for(let i=0;i<N;++i)
  if(n>i) r=Math.max(r,BT(n-i-1)+A[i])
 return M[n]=r}
console.log(BT(N))