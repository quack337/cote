let N=+require('fs').readFileSync(0).toString();
let A=[0,0], B=[0,1];
for (let i=2; i<=N; ++i) {
  A[i] = B[i-1];
  B[i] = B[i-1] + A[i-1];
}
console.log(A[N], B[N]);
