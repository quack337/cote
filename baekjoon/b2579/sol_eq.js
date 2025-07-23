// 답
let A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e),
N=A.shift(), M=[[],[]]
M[0][N-1] = M[1][N-1] = A[N-1]
for (let n=N-2; n>=0; --n) {
  let a=-Infinity, b=-Infinity
  if (n<N-2) b = M[0][n+2]
  M[0][n] = Math.max(M[1][n+1], b) + A[n]
  M[1][n] = b + A[n]
}
console.log(Math.max(M[0][0], N==1 ? 0 : M[0][1]))