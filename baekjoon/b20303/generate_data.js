N=30000;
M=0;
K=10001;
C=[];
for (let i=0; i<N; ++i)
  C[i] = i%3 + 1;
console.log(N, M, K)
console.log(C.join(' '));
