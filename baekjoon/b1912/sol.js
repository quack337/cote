let A=require('fs').readFileSync(0).toString().split(/[ \n]+/).map(e=>+e),
N=A.shift(), P, Q // P: 직전 인덱스까지 최대 구간합, Q: 구간합의 최대값
P = Q = A[0]
for (let i=1; i<N; ++i) {
  P=P>0?P+A[i]:A[i]
  Q = Math.max(Q, P)
}
console.log(Q)