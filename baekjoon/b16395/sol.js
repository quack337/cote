let [R,C]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
let A=Array(R).fill().map((_,r)=>Array(r+1).fill(1));
for (let r=2; r<R; ++r)
for (let c=1; c<r; ++c)
  A[r][c] = A[r-1][c-1] + A[r-1][c];
console.log(A[R-1][C-1]);