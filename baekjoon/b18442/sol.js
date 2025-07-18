M=Math
let [[N,R,L],A]=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e))
S=[]
X1=Infinity
BT(0,0,N-R)
console.log(X1+'\n'+X2)

function BT(n,fr,to) {
  if (n==R) {
    let sum=0
    for (let i=0; i<A.length; ++i) {
      let d=Infinity
      for (let j=0; j<S.length; ++j) {
        let t=M.abs(A[i]-S[j])
        d=M.min(d,M.min(t,L-t))
      }
      sum+=d
    }
    if (sum < X1) {X1=sum; X2=S.join(' ')}
    return
  }
  for (let i=fr; i<=to; ++i) {
    S.push(A[i]); BT(n+1,i+1,to+1); S.pop()
  }
}