let D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let N=D[0][0], A=D[1], B=D[2];
let M=Array(N).fill().map(_=>[]);
console.log(BT(0,100));

function BT(n,a) {
  if (n==N || !a) return 0;
  if (M[n][a]!=undefined) return M[n][a];
  return M[n][a] = Math.max(BT(n+1,a), a<=A[n] ? 0 : BT(n+1,a-A[n])+B[n]);
}