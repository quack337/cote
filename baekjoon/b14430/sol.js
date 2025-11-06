A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[R,C]=A.shift();
for(let r=R-2;r>=0;--r)A[r][C-1]+=A[r+1][C-1];
for(let c=C-2;c>=0;--c)A[R-1][c]+=A[R-1][c+1];
for(let r=R-2;r>=0;--r)
for(let c=C-2;c>=0;--c)A[r][c]+=Math.max(A[r+1][c],A[r][c+1]);
console.log(A[0][0]);  