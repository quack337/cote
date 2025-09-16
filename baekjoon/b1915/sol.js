let IN=require('fs').readFileSync(0).toString().split('\n');
let [R, C] = IN.shift().split(' ').map(e=>+e);
let A = IN.map(s=>s.split('').map(e=>+e));
let x=0;
if (R==1 || C==1) x = A[0][0];
else
  for (let r=R-2; r>=0; --r)
    for (let c=C-2; c>=0; --c)
      if (A[r][c]) {
        A[r][c] = Math.min(A[r+1][c], A[r][c+1], A[r+1][c+1]) + 1;
        if (A[r][c] > x) x = A[r][c];
      }
console.log(x*x);
console.log(A);