A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift()
BT=(n)=>{
  if(!n) return 0
  let r=0
  for(let i=0;i<N;++i)
    if(n>i) r=Math.max(r,BT(n-i-1)+A[i])
  return r;
}
console.log(BT(N))