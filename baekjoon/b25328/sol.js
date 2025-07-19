A=(require('fs').readFileSync(0)+'').split('\n')
K=+A[3]
S=[]
C=new Map()
BT=(n,fr,to)=>{
  if (n==K) {
    let k=S.join('')
    C.set(k, 1+(C.get(k)||0))
    return
  }
  for (let i=fr; i<=to; ++i) {
    S.push(A[t][i]); BT(n+1,i+1,to+1); S.pop()
  }
}
for (t=0; t<3; ++t)
  BT(0,0,A[t].length-K)
let x=[...C].filter(e=>e[1]>1).map(e=>e[0]).sort().join('\n')
console.log(x||-1)