let [[N,K,C],A]=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
C=Math.min(C,A.reduce((r,e)=>r+e-1,0))
X=Infinity
CMP=t=>{
  let s=0
  for (let i=0; i<N; ++i)
    s+=Math.floor(t/A[i])
  return s-K
}
BS=(L,R)=>{
  while (L<=R) {
    let m=Math.floor((L+R)/2), r=CMP(m)
    if (r>=0) R=m-1
    else L=m+1
  }
  return L
}
BT=(n,fr)=>{
  if (n==C) {
    let x=BS(1,1_000_000_000_000)
    if (x<X) X=x
    return
  }
  for (let i=fr; i<N; ++i)
    if (A[i]>1) {--A[i]; BT(n+1,i); ++A[i]}
}
BT(0,0)
console.log(X+'')