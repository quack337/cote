A=(require('fs').readFileSync(0)+'').split(/[ \n]+/).map(e=>+e),
N=A.shift()
P=Q=A[0]
for (i=1;i<N;++i) Q=Math.max(Q,P=(P>0?P:0)+A[i])
console.log(Q)