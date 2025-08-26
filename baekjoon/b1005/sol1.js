let IN = require('fs').readFileSync(0).toString().split(/\s/).map(e=>+e);
let T = IN[0];
let N, K, D, A, ii=1;
for (let t=0; t < T; ++t) {
  N = IN[ii++], K = IN[ii++];
  D = IN.slice(ii, ii+N);
  D.unshift(0);
  ii += N;
  A = Array(N+1).fill().map(_=>[]);
  for (let k=0; k < K; ++k) {
    let x = IN[ii++], y = IN[ii++];
    A[y].push(x);
  }
  W = IN[ii++];
  console.log(DFS(W));
}

function DFS(a) {
  let r = 0, B = A[a];
  for (let i=0; i < B.length; ++i) {
    let b = B[i];
    r = Math.max(r, DFS(b));
  }
  return r + D[a];
}