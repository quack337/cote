// 16401 1654 같은 문제
// 3079 유사한 문제
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let K = parseInt(input[index++]);
let N = parseInt(input[index++]);
let A = [];
for (let i = 0; i < K; ++i)
  A[i] = parseInt(input[index++]);

console.log(파라매트릭서치_최대값(1, Math.pow(2, 31) - 1));

function compare(middle) {
  let count = 0;
  for (let lan of A)
    count += Math.floor(lan / middle)
  return N - count;
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