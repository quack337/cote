// 답
let A=require('fs').readFileSync(0).toString().split(/[ \n]+/).map(e=>+e),
N=A.shift(), P=[], Q=[] // P: 직전 인덱스까지 최대 구간합, Q: 구간합의 최대값
P[0] = Q[0] = A[0]
for (let i=1; i<N; ++i) {
  P[i] = P[i-1]>0 ? P[i-1]+A[i] : A[i]
  Q[i] = Math.max(Q[i-1], P[i])
}
console.log(Q[N-1])