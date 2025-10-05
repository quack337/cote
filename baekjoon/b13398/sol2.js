let A=(require('fs').readFileSync(0)+'').trim().split(/\s+/).map(e=>+e);
let N=A.shift();
let P1=Array(N), P2=Array(N);
X=P1[0]=P2[0]=A[0];
for (let i=1; i<N; ++i) {
  P1[i] = (P1[i-1]<0 ? 0 : P1[i-1]) + A[i];
  P2[i] = Math.max(P2[i-1]<0 ? 0 : P2[i-1], i==1 ? 0 : (P1[i-2]<0 ? 0 : P1[i-2])) + A[i];
  X = Math.max(X, P1[i], P2[i]);
}
console.log(X);
