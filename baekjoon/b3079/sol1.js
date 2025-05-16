// 16401 1654 같은 문제
// 3079 유사한 문제
// 시간 초과!
/*
유효숫자 자릿수 문제 때문인 듯
 let i = 1_111_111_111_111_111_111
1111111111111111200
*/
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[index++]);

console.log(파라매트릭서치_최소값(1, 1_000_000_000_000_000_000));

function compare(시간) {
  let count = 0;
  for (let i of A)
    count += Math.floor(시간 / i)
  return count - M;
}

function 파라매트릭서치_최소값(left, right) {
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r >= 0)
      right = middle - 1;
    else
      left = middle + 1;
  }
  return left;
}