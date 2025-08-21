let IN=require('fs').readFileSync(0).toString().split(/\s/).map(e=>+e);
let [N,K] = IN;
let A = IN.slice(2);
let M = Array(K+1).fill(0);
M[K] = 1;
for (let i=0; i < N; ++i)
  for (let 동전 = A[i], 금액 = K; 금액-동전 >= 0; --금액)
    M[금액-동전] += M[금액];
console.log(M[0]);
console.log(M);
