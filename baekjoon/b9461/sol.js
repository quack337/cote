let A=require('fs').readFileSync(0).toString().split('\n').map(e=>+e),
T=A.shift(), P=[0,1,1,1,2,2]
for (let i=6; i<=100; ++i)
  P[i] = P[i-1] + P[i-5]
let O=[]
for (let t=0; t<T; ++t)
  O.push(P[A[t]])
console.log(O.join('\n'))