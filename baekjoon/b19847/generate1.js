N = 300_0000;
A=[]
for(let i=0;i<N;++i)
  A[i] = (Math.random() * 900_000)|0 + 100_000;
console.log(N+'\n'+A.join(' '))