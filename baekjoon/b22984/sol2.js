A=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=A.shift();
M=Array(N+1).fill().map(_=>[,,]);
M[N]=[0,0];
for(let n=N-1; n>0; --n)
  M[n]= [(M[n+1][1]+2)*A[n] + M[n+1][0]*(1-A[n]),
         (M[n+1][1]+1)*A[n] + (M[n+1][0]+1)*(1-A[n])]; 
console.log(M[1][0]*(1-A[0]) + (M[1][1]+1)*A[0])