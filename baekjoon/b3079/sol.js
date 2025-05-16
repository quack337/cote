// 정답
// 16401 1654 같은 문제
// 3079 유사한 문제
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = BigInt(input[index++]);
console.log(파라매트릭서치_최소값(1n, 1_000_000_000_000_000_000n));

function compare(시간) {
  let count = 0n;
  for (let i of A) {
    let temp = 시간 / i;
    if (temp >= M) return 1;
    count += (시간 / i)
    if (count >= M) return 1;
  }
  return count - BigInt(M);
}

function 파라매트릭서치_최소값(left, right) {
  while (left <= right) {
    let middle = (left + right) / BigInt(2);
    let r = compare(middle);
    if (r >= 0)
      right = middle - 1n;
    else
      left = middle + 1n;
  }
  return Number(left);
}