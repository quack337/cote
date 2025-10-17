D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];B=D[2];
M=Array(N+1).fill().map(e=>Array(N+1).fill(0));
for(let a=N-1;a>=0;--a)
for(let b=N-1;b>=0;--b)
 M[a][b]=Math.max(B[b]<A[a]?M[a][b+1]+B[b]:0,M[a+1][b],M[a+1][b+1]);
console.log(M[0][0])