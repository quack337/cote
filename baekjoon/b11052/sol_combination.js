A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift()
BT=(f,n)=>{
  if(!n) return 0
  let r=0
  for(let i=f;i<N;++i)
    if(n>i) r=Math.max(r,BT(i,n-i-1)+A[i])
  return r;
}
console.log(BT(0,N))