// java로 구현해야 통과. 메모리 초과.
A = (require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N = A.shift(),K=A.shift()
M = Array(K+1).fill(0)
M[0] = 1
for (let i = 0; i < N; ++i) {
  let 동전금액 = A[i], 금액 = 동전금액
  for (let 금액 = 동전금액; 금액 <= K; ++금액)
    M[금액] += M[금액 - 동전금액];  
}
console.log(M[K])