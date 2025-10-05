let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [C,N]=A.shift();
let M=Array(C+1);
console.log(BT(C));

function BT(c) {
  if (c<=0) return 0;
  if (M[c]) return M[c];
  let mx = Infinity;
  for (let i=0; i<N; ++i) {
    let x = BT(c-A[i][1]) + A[i][0];
    if (x<mx) mx=x;
  }
  return M[c]=mx;
}