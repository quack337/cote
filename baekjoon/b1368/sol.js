D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
W=D.slice(1,N+1).map(e=>+e);
A=D.slice(N+1).map(s=>s.split(' ').map(e=>+e));
console.log(N,W,A)