// 답
let A = (require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let N = A.shift(),K=A.shift();
let M = Array(K+1).fill(Infinity);
M[0] = 0;
for (let i=0; i < N; ++i)
  for (let 동전=A[i], j=동전; j<= K; ++j)
    M[j] = Math.min(M[j], M[j-동전]+1);
console.log(M[K] == Infinity ? -1 : M[K]);