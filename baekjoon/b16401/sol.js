// 16401 1654 같은 문제
// 3079 유사한 문제
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let M = parseInt(input[index++]);
let N = parseInt(input[index++]);
let A = [], max = 0;
for (let i = 0; i < N; ++i) {
  A[i] = parseInt(input[index++]);
  if (A[i] > max) max = A[i];
}

console.log(파라매트릭서치_최대값(1, max));

function compare(middle) {
  let count = 0;
  for (let 과자 of A)
    count += Math.floor(과자 / middle)
  return M - count;
}

function 파라매트릭서치_최대값(left, right) {
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r <= 0)
      left = middle + 1;
    else
      right = middle - 1;
  }
  return right;
}
