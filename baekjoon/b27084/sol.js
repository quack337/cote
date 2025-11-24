D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
C=Array(N+1).fill(0);
for(let i=0;i<N;++i)C[A[i]]++;
E=1;F=0;
for(let i=0;i<N;++i)
  if(C[i]) {
    E *= C[i]+1;
    if(C[i]==1) ++F;
  }
console.log(E,F)