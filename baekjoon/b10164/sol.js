let[N,M,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
let A=Array(15).fill().map(_=>Array(15).fill(1));
for(let r=1;r<15;++r)
for(let c=1;c<15;++c)
  A[r][c]=A[r][c-1] + A[r-1][c];
if(K)--K;
let r=(K/M)|0, c=K%M;
console.log(A[r][c]*A[N-r-1][M-c-1]);