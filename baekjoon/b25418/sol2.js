[A,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
M=Array(K+1).fill(Infinity);
M[K]=0;
for(let i=K-1;i>=A;--i)
  M[i]=Math.min(M[i+1],i*2<=K?M[i*2]:Infinity)+1;
console.log(M[A]);