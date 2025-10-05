let A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let N=A.shift();
let P=A[0],Q=A[0];
for (let i=1; i<N; ++i) {
  P=Math.max(A[i],A[i]*P);
  if(P>Q) Q=P;
}
console.log(Q.toFixed(3));