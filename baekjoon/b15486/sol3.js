let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A.shift()[0];
let M=[];
M[N] = 0;
for (let n=N-1; n>=0; --n) {
  let [t,p] = A[n];
  M[n] = Math.max(n+t>N ? 0 : M[n+t]+p, M[n+1]);
}
console.log(M[0]);