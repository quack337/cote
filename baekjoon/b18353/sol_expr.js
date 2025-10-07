A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
P=Array(N).fill(1);
for(let i=N-2; i>=0; --i)
 for (let j=i+1; j<N; ++j)
  if (A[i]>A[j] && P[i]<P[j]+1)P[i] = P[j]+1;
console.log(N-Math.max(...P));