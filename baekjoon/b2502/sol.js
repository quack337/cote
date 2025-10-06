let IN=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let [D,K]=IN;
let A=Array(31), B=Array(31);
A[1]=B[2]=1;
A[2]=B[1]=0;
for (let i=3; i<=30; ++i) {
  A[i] = A[i-1] + A[i-2];
  B[i] = B[i-1] + B[i-2];
}
let b = Math.ceil(K/(A[D]+B[D]));
for (;;++b) {
  let k = K - B[D] * b;
  if (k % A[D]) continue;
  console.log(k/A[D] + '\n' + b);
  break;
}