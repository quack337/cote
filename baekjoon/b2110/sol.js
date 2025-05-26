// 정답
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let C = parseInt(input[index++]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[index++]);

A.sort((a, b) => a - b);
console.log(파라매트릭서치_최대값(1, A[N-1] - A[0]));

function compare(middle) {
  let count = 1, prev = A[0];
  for (let i = 1; i < A.length; ++i)
    if (A[i] - prev >= middle) {
      ++count;
      prev = A[i];
    }
  return C - count;
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
