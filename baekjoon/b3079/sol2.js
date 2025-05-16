// 정답. 그렇지만 BigInt 생성자 대신 100n 리터럴을 사용해도 된다.
// 16401 1654 같은 문제
// 3079 유사한 문제
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[index++]);
console.log(파라매트릭서치_최소값(BigInt(1), BigInt(1_000_000_000_000_000_000)));

function compare(시간) {
  시간 = BigInt(시간)
  let count = BigInt(0);
  for (let i of A) {
    i = BigInt(i)
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
      right = middle - BigInt(1);
    else
      left = middle + BigInt(1);
  }
  return Number(left);
}