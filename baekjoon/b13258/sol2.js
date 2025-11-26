D=(require('fs').readFileSync(0)+'').split('\n')
N=+D[0]
A=D[1].split(' ').map(e=>+e);
J=+D[2];C=+D[3];
S=A.reduce((a,e)=>a+e);
Q=A[0];
for(let i=1;i<=C;++i)Q+=J*Q/(S+J*(i-1));
console.log(Q)