let IN=require('fs').readFileSync(0).toString().split('\n');
let [R, C] = IN.shift().split(' ').map(e=>+e);
let A = IN.map(s=>s.split('').map(e=>+e));
let x=0;
for (let r=R-1; r>=0; --r)
  for (let c=C-1; c>=0; --c) {
    if (r<R-1 && c<C-1 && A[r][c])
      A[r][c] = Math.min(A[r+1][c], A[r][c+1], A[r+1][c+1]) + 1;
    if (A[r][c] > x) x = A[r][c];
  }
console.log(x*x);
