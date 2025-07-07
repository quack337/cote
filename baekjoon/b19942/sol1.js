// stack overflow
let D = require('fs').readFileSync(0).toString().split('\n');
let N = +D[0], C = D[1].split(' ').map(e=>+e);
let A = D.slice(2).map(e=>e.split(' ').map(e=>+e));
let S = [], X = [Infinity];
let B = [0].reduce((r,s) => A[s].map((a,i) => a+r[i]), [0,0,0,0,0]);
DFS(0);
console.log(X[0] +'\n'+ X.slice(1).join(' '));

function DFS(n) {
  if (n == N)
    if (s.length > 0) {
      let B = S.reduce((r,s) => A[s].map((a,i) => a+r[i]), [0,0,0,0,0]);
      console.log(S, B);
      if (B.every((e,i) => e >= C[i]) && B[4] < X[0])
        X = [B[4], ...S];
    }
  else {
    S.push(n); DFS(n+1)
    S.pop(); DFS(n+1)
  }
}

